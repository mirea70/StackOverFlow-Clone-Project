const getQuestion = async () => {
  const page = 1;
  await fetch(
    `http://ec2-15-165-63-80.ap-northeast-2.compute.amazonaws.com:8080/questions/list?page=${page}&size=10`
  )
    .then((res) => {
      return res.json();
    })
    .then((data) => {
      const question_list = data.data;
      const question_list_container = document.createElement("div");
      question_list_container.className = "question_list_container";
      for (let data of question_list) {
        const question_list_span = document.createElement("span");
        question_list_span.className = "question_list_span";
        question_list_span.innerText = data.title;
        question_list_span.onclick = () => move(data.questionId);
        question_list_container.appendChild(question_list_span);
      }
      const qd_container = document.getElementById("qd_container");
      qd_container.appendChild(question_list_container);
    });
};

getQuestion();

const move = (id) => {
  localStorage.setItem("key", id);
  location.href = "boardDetail.html";
};
