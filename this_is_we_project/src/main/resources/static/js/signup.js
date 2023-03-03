  // 아이디 체크
function checkId(elem) {
  elem.addEventListener("keyup", () => {
       let idLength = elem.value.length;
       let idLengthResult = "";
     
    const pattern1 = /^(?!(?:[0-9]+)$)([a-zA-Z]|[0-9a-zA-Z]){4,}$/;

      if (idLength >= 6 && idLength <= 16 && pattern1.test(elem.value)) {
         // 유효한 닉네임인 경우
         idLengthResult = "";
         $(".useridVerificationCheckBtn").attr("disabled", false);
       } else if (idLengthResult === 0) {
         // 아이다가 입력되지 않은 경우
         idLengthResult = "아이디를 입력해주세요.";
         $(".useridVerificationCheckBtn").attr("disabled", true);
         userIdPass = false; // 닉네임이 입력되지 않은 경우 nicknamePass 변수를 false로 설정
       } else {
         // 유효하지 않은 아이디인 경우
         idLengthResult = "6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합";
         $(".useridVerificationCheckBtn").attr("disabled", true);
         userIdPass = false; // 닉네임이 입력되지 않은 경우 nicknamePass 변수를 false로 설정
       }
       // 결과 출력
       document.getElementById("idCheck").innerHTML = idLengthResult;
      console.log("아이디 체크하는 부분에서의 userIdPass :" + userIdPass);
    allcollect();
  });
}

// 비밀번호 체크
function checkPassword(elem) {
  elem.addEventListener("keyup", () => {
    let pattern2 =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
    let pwLength = elem.value.length;
    document.getElementById("passwordCheck").innerHTML =
      pwLength >= 8 && pwLength <= 20 && pattern2.test(elem.value)
        ? ""
        : "8자 이상 20자 이하의 영문, 숫자, 특수문자를 조합";
    allcollect();
  });
}
// 비밀번호 2차 체크
function doubleCheckPassword(elem) {
  elem.addEventListener("keyup", () => {
    let pwLength = elem.value.length;
    document.getElementById("secondaryPasswordConfirmation").innerHTML =
      elem.value === document.getElementById("password").value
        ? ""
        : "비밀번호가 일치하지 않습니다.";
    
    allcollect();
  });
}
// 이름 체크
function checkName(elem) {
  elem.addEventListener("keyup", () => {
    let nameLength = elem.value.length;
    document.getElementById("nameCheck").innerHTML =
      nameLength >= 2 && nameLength <= 10
        ? ""
        : "2자 이상 10자 이하의 이름을 입력해주세요.";
    allcollect();
  });
}

// 닉네임 체크
function checkNickname(elem) {
     elem.addEventListener("keyup", () => {
       let nicknameLength = elem.value.length;
       let nicknameResult = "";
       
       if (nicknameLength >= 2 && nicknameLength <= 15) {
         // 유효한 닉네임인 경우
         nicknameResult = "";
         $(".nicknameVerificationCheckBtn").attr("disabled", false);
       } else if (nicknameLength === 0) {
         // 닉네임이 입력되지 않은 경우
         nicknameResult = "닉네임을 입력해주세요.";
         $(".nicknameVerificationCheckBtn").attr("disabled", true);
         nicknamePass = false; // 닉네임이 입력되지 않은 경우 nicknamePass 변수를 false로 설정
       } else {
         // 유효하지 않은 닉네임인 경우
         nicknameResult = "2자 이상 15자 이하의 닉네임을 입력해주세요.";
         $(".nicknameVerificationCheckBtn").attr("disabled", true);
         nicknamePass = false; // 닉네임이 입력되지 않은 경우 nicknamePass 변수를 false로 설정
       }
       
       // 결과 출력
       document.getElementById("nicknameCheck").innerHTML = nicknameResult;
       console.log("닉네임 체크하는 부분에서의 nicknamePass :" + nicknamePass);
       // 모든 검증 통과 여부 확인
       allcollect();
     });
   }


// 이메일 체크
function checkEmail(elem) {
  elem.addEventListener("keyup", () => {
     let EmailLength = elem.value.length;
     let EmailResult = "";
    const pattern3 =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    
    if (pattern3.test(elem.value)) {
         // 이메일 닉네임인 경우
         EmailResult = "";
         $(".emailVerificationCheckBtn").attr("disabled", false);
       } else if (EmailLength === 0) {
         // 이메일이 입력되지 않은 경우
         EmailResult = "이메일을 입력해주세요.";
         $(".emailVerificationCheckBtn").attr("disabled", true);
         emailCodePass = false; // 이메일이 입력되지 않은 경우 emailCodePass 변수를 false로 설정
       } else {
         // 유효하지 않은 이메일이 경우
         EmailResult = "이메일 형식에 맞게 입력해주세요.";
         $(".emailVerificationCheckBtn").attr("disabled", true);
         emailCodePass = false; // 유효하지 않은 이메일이 입력되지 않은 경우 emailCodePass 변수를 false로 설정
       }
    // 결과 출력
    document.getElementById("emailCheck").innerHTML = EmailResult;
    allcollect();
  });
}


//휴대전화 체크
function checkPhoneCheck(elem) {
  elem.addEventListener("keyup", () => {
    const pattern4 = /^(?:(010\d{4})|(01[1|6|7|8|9]\d{3,4}))(\d{4})$/i;
    document.getElementById("phoneCheck").innerHTML = pattern4.test(
      elem.value
    )
      ? ""
      : "-를 제외한 휴대폰번호를 입력해주세요";
    allcollect();
  });
}


// 전체 체크 및 체크해제
function allchecked(elem) {
  const allow = document.getElementsByClassName("agree");
  if (elem.checked) {
    for (let a = 0; a < allow.length; a++) {
      allow[a].checked = true;
    }
  } else {
    for (let a = 0; a < allow.length; a++) {
      allow[a].checked = false;
    }
  }
  allcollect();
  checkboxisall();
}

// 회원가입 활성화
function allcollect() {
  let button = "allcheck";
  
//다른 입력란 검증 결과가 비어있지 않은 경우
  for (let a = 0; a < document.getElementsByClassName("verification").length; a++) {
    if (!document.getElementsByClassName("verification")[a].innerHTML == "") {
      button = "uncheck";
    }
    
    console.log("이 부분이 uncheck가 되는 것인가?" + button);
  }
//이용약관 동의 여부 확인
  for(let b=1;b<document.getElementsByClassName("agree").length-1;b++){
    if(!document.getElementsByClassName("agree")[b].checked){
      button = "uncheck";
    }  
    console.log("이 부분이 이용약관 uncheck가 되는 것인가?" + button);
  }
  
  
//아이디 검증 통과 여부 확인
  if (!userIdPass || $("#idCheck").html() != "") {
    button = "uncheck";
     console.log("이 부분이 아이디 검증통과 여부 부분이 uncheck가 되는 것인가?" + button);
  }
  
//닉네임 검증 통과 여부 확인
  if (!nicknamePass || $("#nicknameCheck").html() != "") {
    button = "uncheck";
     console.log("이 부분이 닉네임 검증통과 여부 부분이 uncheck가 되는 것인가?" + button);
  }
  
//이메일 검증 통과 여부 확인
  if (!emailCodePass || $("#emailCheck").html() != "") {
    button = "uncheck";
     console.log("이 부분이 이메일 검증통과 여부 부분이 uncheck가 되는 것인가?" + button);
  }
  
  button == "uncheck" ? disable() : able();
  checkboxisall();
}

function able() {
  document.getElementById("signup-button").style.backgroundColor = "black";
  document.getElementById("signup-button").style.color = "white";
  document.getElementById("signup-button").style.pointerEvents = "auto";
  document.getElementById("signup-button").style.cursor = "pointer";
}
function disable() {
  document.getElementById("signup-button").style.backgroundColor =
    "rgb(214, 214, 214)";
  document.getElementById("signup-button").style.color = "grey";
  document.getElementById("signup-button").style.pointerEvents = "none";
  document.getElementById("signup-button").style.cursor = "none";
}

  function checkboxisall(){
  let checkbox = "allcheck"
    for(a=1;a<document.getElementsByClassName("agree").length;a++){
     if(!document.getElementsByClassName("agree")[a].checked){
      checkbox="unchecked";
     }
    }
    if(checkbox=="unchecked"){
      document.getElementsByClassName("agree")[0].checked=false;
    }else{
      document.getElementsByClassName("agree")[0].checked=true;   
    }
}