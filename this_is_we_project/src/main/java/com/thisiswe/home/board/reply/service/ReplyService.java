package com.thisiswe.home.board.reply.service;

import com.thisiswe.home.board.reply.dto.ReplyDTO;

import java.util.List;

//TODO [Service] 게시판-댓글
public interface ReplyService {

	//TODO [Service] 게시글-댓글 - 등록(register)
	Long register(ReplyDTO replyDTO);
	
	//TODO [Service] 게시글-댓글 - 게시판 번호 읽기(get)
	List<ReplyDTO> getList(Long board_num);
}
