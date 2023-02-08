package com.thisiswe.home.notice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//TODO [DTO]Notice 게시판
public class NoticeDTO {
	
	private Long noticeNum;							// 공지사항 번호	
	private String noticeCategory;					// 공지사항 카테고리
	private String noticeTitle;						// 공지사항 제목
	private String noticeContent;					// 공지사항 내용
	private String userId;							// 공지사항 유저ID
	private LocalDateTime regDate;					// 공지사항 등록일
	private LocalDateTime updateDate;				// 공지사항 수정일
	private long noticeVew;							// 공지사항 조회수
	private long replyCount;						// 공지사항 댓글수

}
