const handleLogin = async () => {
  // const login_request_data = {
  //   email: document.getElementById("email").value,
  //   password: document.getElementById("password").value,
  // };
  // await fetch(`http://localhost:3001/member/?email=${login_request_data.email}`)
  //   .then((res) => {
  //     if (!res.ok) {
  //       throw Error("could not fetch the data for that resource");
  //     }
  //     return res.json();
  //   })
  //   .then((data) => {
  //     if (data[0]["login_check"] === "different") {
  //       localStorage.setItem("login_check", data[0]["login_check"]);
  //     } else {
  //       localStorage.setItem("email", data[0].email);
  //       localStorage.setItem("name", data[0].name);
  //       localStorage.setItem("img", data[0].profile_image);
  //     }
  //     return data;
  //   });
  const login_request_data = {
    email: document.getElementById("email").value,
    password: document.getElementById("password").value,
  };
  // await fetch(
  //   `http://ec2-15-165-63-80.ap-northeast-2.compute.amazonaws.com:8080/members/login`,
  //   { method: "POST", body: JSON.stringify(login_request_data) }
  // )
  await fetch(
    `http://ec2-15-165-63-80.ap-northeast-2.compute.amazonaws.com:8080/members/login?email=${login_request_data.email}&password=${login_request_data.password}`,
    { method: "POST" }
  )
    .then((res) => {
      if (res.status === 400) {
        alert("아이디 패스워드 오류입니다.");
        return;
      } else {
        return res.json();
      }
    })
    .then((data) => {
      // localStorage.setItem("login_id", data[member_id]);
      localStorage.setItem("email", data.email);
      localStorage.setItem("name", data.name);
      localStorage.setItem("img", data.profile_image);
      return data;
    })
    .then(() => {
      location.href = "boradMainLogin.html";
    });
};

const handleLogout = () => {
  alert("로그아웃합니다.");
  localStorage.clear();
};

//디테일 이동 테스트용
const handleDetail = () => {
  localStorage.setItem("key", 1);
  location.href = "boradDetail.html";
};
