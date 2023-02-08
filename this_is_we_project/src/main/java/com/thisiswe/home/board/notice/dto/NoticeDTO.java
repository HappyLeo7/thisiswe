package com.thisiswe.home.board.notice.dto;

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
	
	private Long notice_num;						// 공지사항 번호	
	private String notice_category;					// 공지사항 카테고리
	private String notice_title;					// 공지사항 제목
	private String notice_content;					// 공지사항 내용
	private String user_id;							// 공지사항 유저ID
	private LocalDateTime notice_reg_date;			// 공지사항 등록일
	private LocalDateTime notice_update_date;		// 공지사항 수정일
	private int notice_view;						// 공지사항 조회수

}
