package com.thisiswe.home.club.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

//TODO[leo]ClubDTO ( 
public class ClubDTO {
	
	/** 모임번호 */
	private Long clubNum; //모임번호
	private String userId; //유저ID
	private String userNickname; //닉네임
	private String clubPlace;//지역
	private String clubName;//모임명
	private String clubContent;//내용
	private String clubCategory;//관심 카테고리
	private String clubLogo;//로고 이미지
	private String clubLogoUuid;//로고 uuid
	private String clubLogoUrl; //로고 경로
	private Long clubHeadCount;//인원
	private LocalDateTime regDate; //등록일
	private LocalDateTime updateDate; //수정일
	
	//@Builder.Default
	//private List<ClubDTO> clubLogoList =new ArrayList<>(); 
	
	
}
