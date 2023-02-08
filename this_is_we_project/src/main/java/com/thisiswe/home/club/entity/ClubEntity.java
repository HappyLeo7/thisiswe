package com.thisiswe.home.club.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.thisiswe.home.enetity.DateEntity;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString



//TODO [Entity]Club 테이블 컬럼 (모임번호, 유저ID, 지역, 모임명, 내용, 카테고리, 로고이미지, 인원, 등록일, 수정일)
public class ClubEntity extends DateEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "club_num")
	private Long clubNum; //모임번호
	
	//유니크 유저 ID
	@ManyToOne(fetch = FetchType.LAZY)
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
	
	@Column(length=100, name = "club_head_count")
	private Long clubHeadCount;  //인원
	
	
	

}
