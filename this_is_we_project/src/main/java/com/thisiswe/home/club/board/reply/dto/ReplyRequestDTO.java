package com.thisiswe.home.club.board.reply.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="userId")
public class ReplyRequestDTO {
    private String userId;
    private Long boardNum;							// 게시글 번호
    private String boardReplyContent;				// 게시글-댓글 내용
}
