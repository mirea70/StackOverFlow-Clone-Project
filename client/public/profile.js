const email = localStorage.getItem("email")
const name3 = localStorage.getItem("name")
const img = localStorage.getItem("img")
const loginButton = document.querySelector("#loginButton")
const sighupButton = document.querySelector("#sighupButton")
const membericon = document.querySelector(".membericon")
const name2 = document.querySelector(".name")
const askQuestion = document.querySelector(".askQuestion")


if(email) {
  loginButton.classList.add('hide')
  sighupButton.classList.add('hide')
  membericon.classList.remove('hide')
  membericon.src = img
  name2.classList.remove('hide')
  name2.textContent = name3
  askQuestion.classList.remove('hide')
}else {
  loginButton.classList.remove('hide')
  sighupButton.classList.remove('hide')
  membericon.classList.add('hide')
  name2.classList.add('hide')
  askQuestion.classList.add('hide')
}

