package com.thisiswe.home.club.board.reply.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="userId")

//TODO [DTO]Reply 게시판-댓글
public class ReplyDTO{
	
	private Long boardReplyNum;						// 게시글-댓글 번호
	private String boardReplyContent;				// 게시글-댓글 내용
	private String userId;							// 게시글-댓글 유저ID
	private Long boardNum;							// 게시글 번호 
	private LocalDateTime regDate;					// 게시글-댓글 등록일
	private LocalDateTime updateDate;				// 게시글-댓글 수정일

}
