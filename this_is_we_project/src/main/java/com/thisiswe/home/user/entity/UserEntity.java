package com.thisiswe.home.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Builder
@Getter
@ToString
@AllArgsConstructor  // 모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor   // 파라미터가 없는 기본 생성자를 생성

//TODO [Entity]userEntity 테이블 컬럼(아이디, 비밀번호, 닉네임, 성별, 이메일, 핸드폰번호, 외부권한) *권한 같은 경우에는 값으로 새로운 테이블 생성
public class UserEntity {
	
	
	@Id
	@Column(length=100, name="user_id")
	private String userId; // 아이디
	
	@Column(length=100, name="user_password")
	private String userPassword; // 패스워드
	
	@Column(unique = true, length=100, name="user_nickname")
	private String userNickname; // 닉네임
	
	@Column(length=20, name="user_gender")
	private String userGender; // 성별
	
	@Column(unique = true, length=100, name="user_email")
	private String userEmail; // 이메일
	
	@Column(length=100, name="user_phone_numeber")

	private String userPhoneNumber; // 핸드폰번호

	private String userPhoneNumeber; // 핸드폰번호


	// 이미지
	@Column(length = 1000, name="user_image_url")
	private String userImageUrl; // 유저 이미지 경로

	@Column(name="user_fromSocial")
	private boolean fromSocial;   // 외부 권한(ex. 카카오, 구글, 네이버)
	
	// 권한
	@Column
	@Enumerated(value = EnumType.STRING)
	private UserRoleEnum role;
	public void changePassword(String password) {
		this.userPassword = password; // 패스워드 변경
	}

	@Column(unique = true)
	private Long kakaoId;
	
	public UserEntity(String userId, String password, String userNickname, String userGender, String userEmail, String userPhoneNumber, String userImageUrl, UserRoleEnum role) {
		this.userId = userId;
		this.userPassword = password;
		this.userNickname = userNickname;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.userImageUrl = userImageUrl;
		this.role = role;
		}

	public void changeName(String name) {
		this.userNickname = name; // 닉네임 변경
	}

}


