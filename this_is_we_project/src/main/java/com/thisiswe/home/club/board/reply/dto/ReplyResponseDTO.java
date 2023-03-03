package com.thisiswe.home.club.board.reply.dto;

import com.thisiswe.home.club.board.reply.entity.Reply;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReplyResponseDTO {
    private Long replyNum;                          //댓글 넘버
    private String userId;                          //유저 아이디
//    private Long boardNum;							// 게시글 번호
    private String boardReplyContent;				// 게시글-댓글 내용

    public static ReplyResponseDTO toDto(final Reply reply) {
        return ReplyResponseDTO.builder()
                .replyNum(reply.getBoardReplyNum())
                .userId(reply.getUserId().getUserId())
                .boardReplyContent(reply.getBoardReplyContent())
                .build();

    }
}
