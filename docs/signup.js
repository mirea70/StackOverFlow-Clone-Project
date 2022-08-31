const login_button = document.querySelector(".login_button")
const firebaseConfig = {
    apiKey: "AIzaSyBpR4nxkPKpdyaaKJUUhct7AdBTHrNMg7o",
    authDomain: "preproject-45ced.firebaseapp.com",
    databaseURL: "https://preproject-45ced-default-rtdb.firebaseio.com",
    projectId: "preproject-45ced",
    storageBucket: "preproject-45ced.appspot.com",
    messagingSenderId: "903270408485",
    appId: "1:903270408485:web:4e81eb6c9df5da6c137acc"
  };
firebase.initializeApp(firebaseConfig);

const storage = firebase.storage

login_button.onclick = function() {
var file = document.querySelector('#image').files[0];
var storageRef = storage.ref();
var link = storageRef.child('image/' + file.name);
var 업로드 = () =>{ 
    link.put(file)
  }
업로드()
}