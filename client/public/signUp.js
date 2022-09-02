const handleSignUp = () => {
  const check = document.getElementById("checkbox");
  const imageLink = Math.floor(Math.random()*(10-1)+1)
  var imageLink2 = ''
  if(imageLink === 1) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/1.png?alt=media&token=39ab7cc6-72eb-4ee0-bbf3-c235f2b7e40e'  
  }
  if(imageLink === 2) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/2.png?alt=media&token=0fe1ba04-e25b-4ab1-8a88-d85fd43e7378'  
  }
  if(imageLink === 3) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/3.png?alt=media&token=ea283e11-59c9-444d-9c92-bb4dabf46ab1'  
  }
  if(imageLink === 4) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/4.png?alt=media&token=77a4a2bc-687d-4625-9faa-5d2b8de9fd72'  
  }
  if(imageLink === 5) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/5.png?alt=media&token=0b0a685e-b1c5-46a1-a38a-c7d34930ddc1'  
  }
  if(imageLink === 6) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/6.png?alt=media&token=0902adf0-3d18-4c71-a1bf-e08e5459c35b'  
  }
  if(imageLink === 7) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/7.png?alt=media&token=6b44165a-0830-4c96-aa23-97266e4a0e50'  
  }
  if(imageLink === 8) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/8.png?alt=media&token=c9c546cb-b2cb-4732-ab33-642f163983bd'  
  }
  if(imageLink === 9) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/9.png?alt=media&token=304d365f-c97d-4a46-8347-0305f40f2724'  
  }
  if(imageLink === 10) {
    imageLink2 = 'https://firebasestorage.googleapis.com/v0/b/preproject-45ced.appspot.com/o/10.png?alt=media&token=b281fb9f-4329-4388-b4e7-a7011c6134ac'  
  }
  const signUp_request_body = {
    email: document.getElementById("email").value,
    name: document.getElementById("name").value,
    password: document.getElementById("password").value,
    profile_image: imageLink2,
  };
  const singUp = async () => {
    await fetch(
      `http://ec2-15-165-63-80.ap-northeast-2.compute.amazonaws.com:8080/members/join`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(signUp_request_body),
      }
    )
      .then((res) => {
        if (res.status === 200 || res.status === 201) {
          return "회원가입이 완료되었습니다.";
        } else {
          //예시
          alert("이미 가입된..");
          return;
        }
      })
      .then((message) => {
        if (message === "회원가입이 완료되었습니다.") {
          alert(message + "\n로그인해주세요.");
          location.href = "login.html";
        }
      });
  };

  if (check.checked) {
    singUp();
  } else {
    //임의
    alert("광고성 메일 수신 여부를 체크해 주세요(필수)");
  }
};
