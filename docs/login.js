const email = localStorage.getItem("email")
const name = localStorage.getItem("name")
const img = localStorage.getItem("img")
const loginButton = document.querySelector("#loginButton")
const sighupButton = document.querySelector("#sighupButton")
const membericon = document.querySelector(".membericon")
const name2 = document.querySelector(".name")


if(email) {
  loginButton.classList.add('hide')
  sighupButton.classList.add('hide')
  membericon.classList.remove('hide')
  membericon.src = "image/logo.png"
  name2.classList.remove('hide')
  name2.textContent = "고영석"
}else {
  loginButton.classList.remove('hide')
  sighupButton.classList.remove('hide')
  membericon.classList.add('hide')
  name2.classList.add('hide')
}

