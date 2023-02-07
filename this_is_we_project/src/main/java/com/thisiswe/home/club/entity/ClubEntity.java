package com.thisiswe.home.club.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data



//TODO [Entity]Club 테이블 컬럼 (모임번호, 유저ID, 지역, 모임명, 내용, 카테고리, 로고이미지, 인원, 등록일, 수정일)
public class ClubEntity extends DateEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long club_num; //모임번호
	
	//유니크 유저 ID
	@Column(length=100, unique=true)
	private String user_id; //유저ID
	
	@Column(length=100)
	private String club_place; //지역
	
	@Column(length=100)
	private String club_name; //모임명
	
	@Column(length=1000)
	private String club_content; //내용
	
	@Column(length=100)
	private String club_category; //관심 카테고리
	
	@Column(length=100)
	private String club_logo; //로고 이미지
	
	@Column(length=100)
	private Long club_head_count;  //인원
	
	
	

}