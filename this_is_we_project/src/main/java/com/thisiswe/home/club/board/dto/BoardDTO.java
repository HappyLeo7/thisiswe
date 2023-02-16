package com.thisiswe.home.club.board.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//TODO [DTO]Board 게시판
public class BoardDTO {
	
	private Long boardNum;							// 게시글 번호	
	private String boardCategory;					// 게시판 카테고리
	private String boardTitle;						// 게시판 제목
	private String boardContent;					// 게시판 내용
	private String userId;							// 게시판 유저ID
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime regDate;					// 게시판 등록일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime updateDate;				// 게시판 수정일
	private Long boardView;							// 게시판 조회수
	private int replyCount;						// 게시판 댓글수
}
