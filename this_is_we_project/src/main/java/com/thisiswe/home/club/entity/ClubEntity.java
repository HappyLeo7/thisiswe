package com.thisiswe.home.club.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.member.ClubMemberEntity;
import com.thisiswe.home.club.photo.entity.PhotoEntity;
import com.thisiswe.home.enetity.DateEntity;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
//@ToString(exclude = "userId")

//TODO [Entity]Club 테이블 컬럼 (모임번호, 유저ID, 지역, 모임명, 내용, 카테고리, 로고이미지, 인원, 등록일, 수정일)
public class ClubEntity extends DateEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clubNum; //모임번호
	
	//유니크 유저 ID
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity userId; //유저ID
	
	@Column(length=100, name = "club_place")
	private String clubPlace; //지역
	
	@Column(length=100, name ="club_name")
	private String clubName; //모임명
	
	@Column(length=1000, name = "club_content")
	private String clubContent; //내용
	
	@Column(length=100, name = "club_category")
	private String clubCategory; //관심 카테고리
	
	@Column(length=100, name = "club_logo")
	private String clubLogo; //로고 이미지
	
	@Column(length=300, name = "club_logo_uuid")
	private String clubLogoUuid; //로고 uuid
	
	@Column(length=300, name = "club_logo_url")
	private String clubLogoUrl; //로고 경로
	
	@Column(length=100, name = "club_head_count")
	private Long clubHeadCount;  //인원
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClubMemberEntity> clubMemberEntity;
	@OneToMany(mappedBy = "clubNum", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PhotoEntity> photoEntity;
	@OneToMany(mappedBy = "clubNum", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CalendarEntity> calendarEntitiy;
	@OneToMany(mappedBy = "clubNum", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Board> boardEntity;
	
	
	
	
	public void changeLogo(String clubPlace
			
			, String clubName, String clubContent, String clubCategory, 
			String clubLogo,String clubLogoUuid,String clubLogoUrl, Long clubHeadCount
			
			) {
		this.clubPlace =clubPlace;
		this.clubName =clubName;
		this.clubContent=clubContent;
		this.clubCategory=clubCategory;
		this.clubLogo=clubLogo;
		this.clubLogoUuid=clubLogoUuid;
		this.clubLogoUrl=clubLogoUrl;
		this.clubHeadCount=clubHeadCount;
		
		
	}
	
public void change(String clubPlace
			
			, String clubName, String clubContent, String clubCategory, 
			 Long clubHeadCount
			
			) {
		this.clubPlace =clubPlace;
		this.clubName =clubName;
		this.clubContent=clubContent;
		this.clubCategory=clubCategory;
		this.clubHeadCount=clubHeadCount;
		
		
	}

}
