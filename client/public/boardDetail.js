//boardMain에서 질문 타이틀 클릭시 로컬스토리지에 저장된 "key"의 value로 question_id 할당
localStorage.setItem("key", 1);
const question_id = localStorage.getItem("key");
const url = "http://ec2-15-165-63-80.ap-northeast-2.compute.amazonaws.com:8080";

const getData = async (url, id) => {
  await fetch(`${url}/question/${id}`)
    .then((res) => {
      if (!res.ok) {
        throw Error("could not fetch the data for that resource");
      }
      return res.json();
    })
    .then((data) => {
      const question_data = data;
      const answer_data = question_data.data;
      let today = new Date();
      const getDateDiff = (d1, d2) => {
        const date1 = new Date(d1);
        const date2 = new Date(d2);
        const diffDate = date1.getTime() - date2.getTime();
        return Math.abs(diffDate / (1000 * 60 * 60 * 24));
      };

      //---- upper 질문 타이틀, 날짜, 뷰 등록 div

      //투표 컨테이터 및 컨테이너 렌더링 위한 함수 구현
      const makeVoteBar = (target, data, parent) => {
        const qd_lower_vote = document.createElement("div");
        qd_lower_vote.className = `qd_lower_vote qd_lower_${target}_vote`;
        const vote_up = document.createElement("i");
        vote_up.className = "fa-solid fa-caret-up fa-3x";
        const vote_span = document.createElement("span");
        vote_span.innerText = data.vote;
        const vote_down = document.createElement("i");
        vote_down.className = "fa-solid fa-caret-down fa-3x";
        qd_lower_vote.append(vote_up, vote_span, vote_down);
        parent.appendChild(qd_lower_vote);
      };

      const makeContent = (target, data, parent) => {
        const qd_lower_content_wrapper = document.createElement("div");
        qd_lower_content_wrapper.className = `qd_lower_content_wrapper qd_lower_${target}_content_wrapper`;
        const qd_lower_content = document.createElement("div");
        qd_lower_content.className = "qd_lower_content";
        qd_lower_content.innerHTML = data.contents;
        qd_lower_content_wrapper.appendChild(qd_lower_content);

        if (target === "question") {
          //태그내용 일시 없앰
          // const qd_lower_tags = document.createElement("div");
          // qd_lower_tags.className = "qd_lower_tags";
          // const tags = data.tags.split(" ");
          // for (let tag of tags) {
          //   let qd_lower_tags_detail = document.createElement("a");
          //   qd_lower_tags_detail.className = "qd_lower_tags_detail";
          //   qd_lower_tags_detail.innerText = tag;
          //   qd_lower_tags.appendChild(qd_lower_tags_detail);
          // }
          // qd_lower_content_wrapper.appendChild(qd_lower_tags);
        }

        //   if (target === "answer") {
        //     console.log(data.contents);
        //     qd_lower_content.innerHTML = data.contents;
        //     qd_lower_content_wrapper.appendChild(qd_lower_content);
        //   }

        const qd_lower_info = document.createElement("div");
        qd_lower_info.className = "qd_lower_info";
        const qd_lower_info_control = document.createElement("div");
        qd_lower_info_control.className = "qd_lower_info_control";
        const button_arr = ["Share", "Edit", "Follow"];
        for (let button of button_arr) {
          let qd_lower_info_control_button = document.createElement("a");
          qd_lower_info_control_button.innerText = button;
          qd_lower_info_control.appendChild(qd_lower_info_control_button);
        }
        const qd_lower_info_modified = document.createElement("div");
        qd_lower_info_modified.className = "qd_lower_info_modified";
        const qd_lower_info_modified_detail = document.createElement("a");
        qd_lower_info_modified_detail.className =
          "qd_lower_info_modified_detail";
        qd_lower_info_modified_detail.innerText = data.modified_at;
        qd_lower_info_modified.appendChild(qd_lower_info_modified_detail);
        const qd_lower_info_users = document.createElement("div");
        qd_lower_info_users.className = "qd_lower_info_users";
        qd_lower_info_users.innerText = data.writer;
        qd_lower_info.append(
          qd_lower_info_control,
          qd_lower_info_modified,
          qd_lower_info_users
        );
        qd_lower_content_wrapper.appendChild(qd_lower_info);
        parent.appendChild(qd_lower_content_wrapper);
      };

      const qd_question_title = document.getElementById("qd_question_title");
      qd_question_title.innerText = question_data.title;

      const qd_question_created_time = document.getElementById(
        "qd_question_created_time"
      );
      qd_question_created_time.datetime = question_data.created_at;

      let diff = Math.floor(getDateDiff(question_data.created_at, today));
      diff === 0
        ? (qd_question_created_time.innerText = "Today")
        : diff === 1
        ? (qd_question_created_time.innerText = "yesterday")
        : (qd_question_created_time.innerText = diff + " days ago");

      const qd_question_modified_time = document.getElementById(
        "qd_question_modified_time"
      );
      qd_question_modified_time.datetime = question_data.modified_at;
      diff = Math.floor(getDateDiff(question_data.modified_at, today));
      diff === 0
        ? (qd_question_modified_time.innerText = "Today")
        : diff === 1
        ? (qd_question_modified_time.innerText = "yesterday")
        : (qd_question_modified_time.innerText = diff + " days ago");

      const qd_question_view = document.getElementById("qd_question_view");
      const qd_question_view_span = document.createElement("span");
      qd_question_view_span.innerText = "Viewed";
      qd_question_view.appendChild(qd_question_view_span);
      qd_question_view.appendChild(document.createTextNode(question_data.view));
      const qd_lower_left_container = document.getElementById(
        "qd_lower_left_container"
      );
      //question 컨테이너 렌더링
      const qd_lower_question_container = document.createElement("div");
      qd_lower_question_container.className = "qd_lower_question_container";
      makeVoteBar("question", question_data, qd_lower_question_container);
      makeContent("question", question_data, qd_lower_question_container);
      qd_lower_left_container.appendChild(qd_lower_question_container);

      //answer 컨테이너 렌더링
      // if (answer_data.length > 0) {
      //   const qd_lower_answer_container = document.createElement("div");
      //   qd_lower_answer_container.className = "qd_lower_answer_container";

      //   const qd_lower_answer_header = document.createElement("div");
      //   qd_lower_answer_header.className = "qd_lower_answer_header";
      //   const qd_lower_answer_header_main = document.createElement("div");
      //   qd_lower_answer_header_main.className = "qd_lower_answer_header_main";
      //   const qd_lower_answer_header_main_title = document.createElement("h2");
      //   qd_lower_answer_header_main_title.className =
      //     "qd_lower_title qd_lower_answer_header_main_title";
      //   qd_lower_answer_header_main_title.innerText = `${answer_data.length} Answers`;
      //   qd_lower_answer_header_main.appendChild(
      //     qd_lower_answer_header_main_title
      //   );
      //   qd_lower_answer_header.appendChild(qd_lower_answer_header_main);
      //   qd_lower_answer_container.appendChild(qd_lower_answer_header);
      //   //   const qd_lower_answer_header_filter = document.createElement("div");
      //   //   qd_lower_answer_header_filter.className = "qd_lower_answer_header_filter";

      //   for (let answer of answer_data) {
      //     const qd_lower_answer_wrapper = document.createElement("div");
      //     qd_lower_answer_wrapper.className = "qd_lower_answer_wrapper";
      //     makeVoteBar("answer", answer, qd_lower_answer_wrapper);
      //     makeContent("answer", answer, qd_lower_answer_wrapper);
      //     qd_lower_answer_container.appendChild(qd_lower_answer_wrapper);
      //   }
      //   qd_lower_left_container.appendChild(qd_lower_answer_container);
      // }
      return data;
    })
    .then((x) => {
      const qd_lower_left_container = document.getElementById(
        "qd_lower_left_container"
      );
      const qd_lower_input_container = document.getElementById(
        "qd_lower_input_container"
      );
      console.log(qd_lower_input_container);
      qd_lower_left_container.appendChild(qd_lower_input_container);
    });
};
getData(url, question_id);

const setAnswer = () => {
  const input_data = CKEDITOR.instances.editor1.getData();
  alert("답변을 등록합니다.");
  // question_id(선언할당되어있음), data 인풋내용, 사용자정보 바디를 포함해서 answer로 post요청
  const date = new Date().toJSON();
  const body = {
    contents: input_data,
    member_id: localStorage.getItem("id"),
    questionId: question_id,
    vote: 0,
    created_at: date,
  };
};
