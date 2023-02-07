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
	private String user_id; // 아이디
	
	@Column(length=100)
	private String user_password; // 패스워드
	
	@Column(length=100)
	private String user_nickname; // 닉네임
	
	@Column(length=20)
	private String user_gender; // 성별
	
	@Column(length=100)
	private String user_email; // 이메일
	
	@Column(length=100)
	private String user_phone_numeber; // 핸드폰번호
	

	// TODO [Entity] 컬렉션 관리를 위한 별도 테이블 생성
	@ElementCollection(fetch = FetchType.LAZY)
	@Builder.Default
	private Set<UserRole> roleSet = new HashSet<>(); // 중복 허용 x
	
	public void changePassword(String password) {
		this.user_password = password; // 패스워드 변경
	}
	
	public void changeName(String name) {
		this.user_nickname = name; // 닉네임 변경
	}

	public void addUserRole(UserRole user) {
		roleSet.add(user); // 권한 추가
	}
}

