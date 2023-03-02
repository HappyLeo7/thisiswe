package com.thisiswe.home.user.mypage;

import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor  // 모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor   // 파라미터가 없는 기본 생성자를 생성

public class MypageDTO {
	
	private String userId; // 아이디
	
	private String userPassword; // 패스워드
	
	private String userNickname; // 닉네임
	
	private String userName; // 실제 이름
	
	private String userGender; // 성별
	
	private String userEmail; // 이메일
	
	private String userPhoneNumber; // 핸드폰번호

	private MultipartFile userImageFile; // 유저 이미지 파일
	
	private String userImageUrl; // 유저 이미지 경로
	
	public MypageDTO(UserEntity userEntity) {
		this.userId = userEntity.getUserId();
		this.userPassword = userEntity.getUserPassword();
		this.userNickname = userEntity.getUserNickname();
		this.userName = userEntity.getUserName();
		this.userGender = userEntity.getUserGender();
		this.userEmail = userEntity.getUserEmail();
		this.userPhoneNumber = userEntity.getUserPhoneNumber();
		this.userImageUrl = userEntity.getUserImageUrl();
	}

//	public void changeNickName(String name) {
//		this.userNickname = name; // 닉네임 변경
//	}
//	
//	
//	public void changePassword(String password) {
//		this.userPassword = password; // 패스워드 변경
//	}

}


