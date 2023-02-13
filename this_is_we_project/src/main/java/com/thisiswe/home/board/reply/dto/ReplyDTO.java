package com.thisiswe.home.board.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//TODO [DTO]Reply 게시판-댓글
public class ReplyDTO {
	
	private Long board_reply_num;				// 게시글-댓글 번호
	private String board_reply_content;			// 게시글-댓글 내용
	private String user_id;						// 게시글-댓글 유저ID
	private Long board_num;						// 게시글 번호 
	private LocalDateTime regDate;				// 게시글-댓글 등록일
	private LocalDateTime updateDate;			// 게시글-댓글 수정일

}
