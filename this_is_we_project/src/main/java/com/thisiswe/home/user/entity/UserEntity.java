package com.thisiswe.home.user.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.member.ClubMemberEntity;
import com.thisiswe.home.club.photo.entity.PhotoEntity;
import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceReviewEntity;
import com.thisiswe.home.place.reservation.entity.PlaceReservationEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Builder
@Getter
//@ToString
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
	
	@Column(unique = true, length=100, name="user_name")
	private String userName; // 실제 이름
	
	@Column(length=20, name="user_gender")
	private String userGender; // 성별
	
	@Column(unique = true, length=100, name="user_email")
	private String userEmail; // 이메일
	
	@Column(length=100, name="user_phone_number")
	private String userPhoneNumber; // 핸드폰번호

	// 이미지
	@Column(length = 1000, name="user_image_url")
	private String userImageUrl; // 유저 이미지 경로

	@Column(name="user_fromSocial")
	private boolean fromSocial;   // 외부 권한(ex. 카카오, 구글, 네이버)
	
	// 권한
	@Column
	@Enumerated(value = EnumType.STRING)
	private UserRoleEnum role;
	

	@Column(unique = true)
	private Long kakaoId;
	
	
	public UserEntity(String userId, String password, String userNickname, String userName ,String userGender, String userEmail, String userPhoneNumber, String userImageUrl, UserRoleEnum role) {
		this.userId = userId;
		this.userPassword = password;
		this.userNickname = userNickname;
		this.userName = userName;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.userImageUrl = userImageUrl;
		this.role = role;
		this.kakaoId = null;
		}
	
	public UserEntity(String userId, String password, String userNickname, String userName, String userGender, String userEmail, String userPhoneNumber, String userImageUrl, UserRoleEnum role, Long kakaoId) {
		this.userId = userId;
		this.userPassword = password;
		this.userNickname = userNickname;
		this.userName = userName;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.userImageUrl = userImageUrl;
		this.role = role;
		this.kakaoId = kakaoId;
		}

	public void changeNickName(String name) {
		this.userNickname = name; // 닉네임 변경
	}
	
	
	public void changePassword(String password) {
		this.userPassword = password; // 패스워드 변경
	}

	public void changeImage(String userImageUrl) {
		this.userImageUrl = userImageUrl; // 이미지 변경
	}
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlaceEntity> places;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlaceReservationEntity> placeReservations;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlaceReviewEntity> placeReviews;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Board> boards;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reply> replies;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CalendarEntity> calendars;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ClubEntity> clubs;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ClubMemberEntity> clubMembers;
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PhotoEntity> photos;
  
}

