package com.thisiswe.home.board.reply.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//TODO [DTO]Reply 게시판-댓글
public class ReplyDTO {
	
	private Long boardReplyNum;					// 게시글-댓글 번호
	private String boardReplyContent;			// 게시글-댓글 내용
	private String userId;						// 게시글-댓글 유저ID
	private Long boardNum;						// 게시글 번호 
	private LocalDateTime regDate;				// 게시글-댓글 등록일
	private LocalDateTime updateDate;			// 게시글-댓글 수정일

}
