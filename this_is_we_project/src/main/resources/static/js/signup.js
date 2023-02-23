// 아이디 체크
function checkId(elem) {
  elem.addEventListener("keyup", () => {
    const pattern1 = /^(?!(?:[0-9]+)$)([a-zA-Z]|[0-9a-zA-Z]){4,}$/;
    let idLength = elem.value.length;
    document.getElementById("idCheck").innerHTML =
      idLength >= 6 && idLength <= 16 && pattern1.test(elem.value)
        ? ""
        : "6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합";
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
function namecheck(elem) {
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
function nicknamecheck(elem) {
  elem.addEventListener("keyup", () => {
    let nicknameLength = elem.value.length;
    document.getElementById("nicknameCheck").innerHTML =
      nicknameLength >= 2 && nicknameLength <= 15
        ? ""
        : "2자 이상 15자 이하의 닉네임을 입력해주세요.";
    allcollect();
  });
}


// 이메일 체크
function emailcheck(elem) {
  elem.addEventListener("keyup", () => {
    const pattern3 =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    document.getElementById("emailCheck").innerHTML = pattern3.test(elem.value)
      ? ""
      : "이메일 형식에 맞게 입력해주세요.";
    allcollect();
  });
}
// 휴대전화 체크
function phoneCheck(elem) {
  elem.addEventListener("keyup", () => {
    const pattern4 = /^(?:(010\d{4})|(01[1|6|7|8|9]\d{3,4}))(\d{4})$/i;
    document.getElementById("phonenumCheck").innerHTML = pattern4.test(
      elem.value
    )
      ? ""
      : "-를 제외한 휴대폰번호를 입력해주세요";
    allcollect();
    // 인증 번호 받기 활성화
    if (document.getElementById("phonenumCheck").innerHTML == "") {
      document.getElementById("verificationPhonenum").style.backgroundColor = "black";
      document.getElementById("verificationPhonenum").style.color = "white";
      document.getElementById("verificationPhonenum").style.pointerEvents = "auto";
      document.getElementById("verificationPhonenum").style.cursor = "pointer";
    } else {
      document.getElementById("verificationPhonenum").style.backgroundColor =
        "rgb(214, 214, 214)";
      document.getElementById("verificationPhonenum").style.color = "grey";
      document.getElementById("verificationPhonenum").style.pointerEvents = "none";
      document.getElementById("verificationPhonenum").style.cursor = "none";
    }
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
  for (let a = 0; a < document.getElementsByClassName("verification").length; a++) {
    if (!document.getElementsByClassName("verification")[a].innerHTML == "") {
      button = "uncheck";
    }
  }
  for(let b=1;b<document.getElementsByClassName("agree").length-1;b++){
    if(!document.getElementsByClassName("agree")[b].checked){
      button = "uncheck";
    }  
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

