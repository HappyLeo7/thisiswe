package com.thisiswe.home.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//TODO [DTO]Reply 공지사항-댓글
public class ReplyDTO {
	
	private Long boardReplyNum;					// 공지사항-댓글 번호
	private String boardReplyContent;			// 공지사항-댓글 내용
	private String userId;						// 공지사항-댓글 유저ID
	private Long boardNum;						// 공지사항 번호 
	private LocalDateTime regDate;				// 공지사항-댓글 등록일
	private LocalDateTime updateDate;			// 공지사항-댓글 수정일

}
