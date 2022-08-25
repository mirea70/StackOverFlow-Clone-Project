const login_button = document.querySelector(".login");

const validateCheck = (event) => {
  let email = document.getElementById("email").value;
  let password = document.getElementById("password").value;
  if (email === null || email === "" || email === undefined) {
    alert("Please enter the email.");
    event.preventDefault();
    return;
  }
  if (password === null || password === "" || password === undefined) {
    alert("Please enter the password.");
    event.preventDefault();
    return;
  }

  alert("Login successful");
};

login_button.onclick = () => {
  //리렌더링 되게(계속 자식요소 추가 되지 않도록)
  const main = document.getElementById("main");
  while (main.firstChild) {
    main.firstChild.remove();
  }
  const footer_container = document.getElementById("footer_container");
  while (footer_container.firstChild) {
    footer_container.firstChild.remove();
  }

  // 전체 로그인 페이지 감싸는 컨테이너(login_container) 및 로그인페이지 내 요소들을 감싸는 자식 컨테이너(login_main_container) 생성
  const login_container = document.createElement("section");
  login_container.className = "login_container";
  const login_main_container = document.createElement("div");
  login_main_container.className = "login_main_container";

  //로고부분
  const login_logo_container = document.createElement("div");
  login_logo_container.className = "login_logo_container";
  const login_logo = document.createElement("i");
  login_logo.className = "fa-brands fa-stack-overflow ";
  login_logo_container.appendChild(login_logo);
  login_main_container.appendChild(login_logo_container);

  //소셜로그인부문
  const social = ["Google", "Github", "Facebook"];
  const login_social_container = document.createElement("div");
  login_social_container.className = "login_social_container";
  social.forEach((el) => {
    const button = document.createElement("button");
    button.className = el;
    button.innerText = `Log In With ${el}`;
    login_social_container.appendChild(button);
  });
  login_main_container.appendChild(login_social_container);

  //기본로그인부분
  const login_basic_container = document.createElement("div");
  login_basic_container.className = "login_basic_container";
  const login_basic_wrapper = document.createElement("form");
  login_basic_wrapper.className = "login_basic_wrapper";
  //
  const id_container = document.createElement("div");
  id_container.className = "id_container";
  const id_label = document.createElement("label");
  id_label.className = "id_label";
  id_label.innerText = "Email";
  const id_input_container = document.createElement("div");
  id_input_container.className = "id_input_container";
  const id_inputBox = document.createElement("input");
  id_inputBox.id = "email";
  id_inputBox.type = "email";
  id_input_container.appendChild(id_inputBox);
  id_container.appendChild(id_label);
  id_container.appendChild(id_input_container);
  login_basic_wrapper.appendChild(id_container);
  //
  const password_container = document.createElement("div");
  password_container.className = "password_container";
  const password_upper_container = document.createElement("div");
  password_upper_container.className = "password_upper_container";
  const pw_label = document.createElement("label");
  pw_label.className = "pw_label";
  pw_label.innerText = "Password";
  const pw_forgot = document.createElement("a");
  pw_forgot.className = "pw_forgot";
  pw_forgot.innerText = "Forgot password?";
  password_upper_container.appendChild(pw_label);
  password_upper_container.appendChild(pw_forgot);
  const pw_input_container = document.createElement("div");
  pw_input_container.className = "pw_input_container";
  const pw_inputBox = document.createElement("input");
  pw_inputBox.id = "password";
  pw_inputBox.type = "password";
  pw_input_container.appendChild(pw_inputBox);
  password_container.appendChild(password_upper_container);
  password_container.appendChild(pw_input_container);
  login_basic_wrapper.appendChild(password_container);
  //
  const login_button_container = document.createElement("div");
  login_button_container.className = "login_button_container";
  const login_button = document.createElement("button");
  login_button.className = "login_button";
  login_button.innerText = "Log in";
  login_button.addEventListener("click", validateCheck);
  login_button_container.appendChild(login_button);
  login_basic_wrapper.appendChild(login_button_container);
  //
  login_basic_container.appendChild(login_basic_wrapper);
  login_main_container.appendChild(login_basic_container);

  //정보부분
  const login_info_container = document.createElement("div");
  login_info_container.className = "login_info_container";
  login_info_container.innerText = "Don’t have an account?";
  const login_info_signUp = document.createElement("a");
  login_info_signUp.innerText = "Sign up";
  login_info_container.appendChild(login_info_signUp);
  const login_info_employee = document.createElement("div");
  login_info_employee.innerText = "Are you an employer?";
  const login_info_employee_signUp = document.createElement("a");
  login_info_employee_signUp.innerText = "Sign up on Talent";
  login_info_employee.appendChild(login_info_employee_signUp);
  login_info_container.appendChild(login_info_employee);

  login_main_container.appendChild(login_info_container);
  //노드추가
  login_container.appendChild(login_main_container);

  main.appendChild(login_container);
};
