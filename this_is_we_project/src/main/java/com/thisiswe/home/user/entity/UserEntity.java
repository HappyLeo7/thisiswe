package com.thisiswe.home.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@AllArgsConstructor
@NoArgsConstructor
// TODO [Entity]userEntity 테이블 컬럼(아이디, 비밀번호, 닉네임, 성별, 이메일, 핸드폰번호) *권한 같은 경우에는 값으로 새로운 테이블 생성
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
	private String userPhoneNumeber; // 핸드폰번호
	
	// TODO [Entity] 컬렉션 관리를 위한 별도 테이블 생성
	@ElementCollection(fetch = FetchType.LAZY)
	@Builder.Default
	private Set<UserRole> roleSet = new HashSet<>(); // 중복 허용 x
	
	public void changePassword(String password) {
		this.userPassword = password; // 패스워드 변경
	}
	
	public void changeName(String name) {
		this.userNickname = name; // 닉네임 변경
	}

	public void addUserRole(UserRole user) {
		roleSet.add(user); // 권한 추가
	}
}

