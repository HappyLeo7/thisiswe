package com.thisiswe.home.board.free.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//TODO [DTO]Board 게시판
public class BoardDTO {
	
	private Long board_num;							// 게시글 번호	
	private String board_category;					// 게시판 카테고리
	private String board_title;						// 게시판 제목
	private String board_content;					// 게시판 내용
	private String user_id;							// 게시판 유저ID
	private LocalDateTime board_reg_date;			// 게시판 등록일
	private LocalDateTime board_update_date;		// 게시판 수정일
	private int board_view;							// 게시판 조회수
}
