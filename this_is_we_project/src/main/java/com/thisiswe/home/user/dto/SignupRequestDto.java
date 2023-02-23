package com.thisiswe.home.user.dto;

import lombok.Getter;
import lombok.Setter;

@Setter // 접근자
@Getter // 설정자
public class SignupRequestDto {
	private String userId;
	private String userPassword;
	private String userNickname;
	private String userName;
	private String userGender;
	private String userEmail;
	private String userPhoneNumber;
	private String userImageUrl;
	private boolean admin = false;
	private String adminToken = "";


//	여기서부터 추가
	private String authCode;
	
}
