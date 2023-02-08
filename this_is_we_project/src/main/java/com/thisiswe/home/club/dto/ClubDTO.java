package com.thisiswe.home.club.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

//TODO[leo]ClubDTO ( 
public class ClubDTO {
	
	private String userId; //유저ID
	private String clubPlace;//지역
	private String clubName;//모임명
	private String clubContent;//내용
	private String clubCategory;//관심 카테고리
	private String clubLogo;//로고 이미지
	private Long clubHeadCount;//인원
	private LocalDateTime regDate; //등록일
	private LocalDateTime updateDate; //수정일
	
}
