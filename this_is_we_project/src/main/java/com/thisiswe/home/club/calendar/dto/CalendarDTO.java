package com.thisiswe.home.club.calendar.dto;

import java.time.LocalDateTime;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalendarDTO {

	private Long clubCalendarNum;
	private ClubEntity clubNum;
	/**유저ID*/
	private ClubEntity userId; //유저ID
	private UserEntity userNickname; //닉네임
	/**
	 * 제목
	 */
	private String clubCalendarTitle; //제목
	
	/**
	 * 내용
	 */
	private String clubCalendarContent; //내용
	
	/**
	 * 일정 날짜
	 */
	private String clubCalendarDate; //일정 날짜
	
	
	
	/**
	 * 일정 시간
	 */
	private String clubCalendarTime; //일정 시간
	/**
	 * 일정 ?시
	 */
	private String clubCalendarTimeH; //일정 시간
	/**
	 * 일정 ?분
	 */
	private String clubCalendarTimeM; //일정 시간
	
	/**
	 * 장소
	 */
	private String clubCalendarPlace; //장소
	
	/**
	 * 인원
	 */
	private Long clubCalendarHeadCount; //인원
	
	/**
	 * 비용
	 */
	private Long clubCalendarPrice; //비용
	
	private LocalDateTime regDate; //등록일
	private LocalDateTime updateDate; //수정일
}
