
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
  });
}


function able() {
  document.getElementById("modify-button").style.backgroundColor = "black";
  document.getElementById("modify-button").style.color = "white";
  document.getElementById("modify-button").style.pointerEvents = "auto";
  document.getElementById("modify-button").style.cursor = "pointer";
}

function disable() {
  document.getElementById("modify-button").style.backgroundColor =
    "rgb(214, 214, 214)";
  document.getElementById("modify-button").style.color = "grey";
  document.getElementById("modify-button").style.pointerEvents = "none";
  document.getElementById("modify-button").style.cursor = "none";
}



