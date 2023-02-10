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
@ToString(exclude = "roleSet")
@AllArgsConstructor
@NoArgsConstructor
// TODO [Entity]userEntity 테이블 컬럼(아이디, 비밀번호, 닉네임, 성별, 이메일, 핸드폰번호, 소셜로그인) *권한 같은 경우에는 값으로 새로운 테이블 생성
public class UserEntity {
	
	@Id
	@Column(length=100, name = "user_id")
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
	
	@Column(name="user_fromSocial")
	private boolean fromSocial;   // 소셜 로그인(ex. 카카오, 구글, 네이버)
	
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
	
	// 회원가입 화면으로부터 넘어오는 가입정보를 담을 dto를 통해 회원정보를 저장
//	public static UserEntity createUser(UserFormDTO userFormDTO) {
//		UserEntity userEntity = UserEntity.builder()
//				.userId(userFormDTO.getUserId())
//				.userPassword(userFormDTO.getUserPassword())
//				.userNickname(userFormDTO.getUserNickname())
//				.userEmail(userFormDTO.getUserEmail())
//				.userPhoneNumeber(userFormDTO.getUserPoneNumber())
//				.build();
//		
//		return userEntity;
//	}
}

