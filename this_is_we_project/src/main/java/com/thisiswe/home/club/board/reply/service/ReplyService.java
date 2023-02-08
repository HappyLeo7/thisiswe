package com.thisiswe.home.club.board.reply.service;

import java.util.List;

import com.thisiswe.home.club.board.reply.dto.ReplyDTO;

//TODO [Service] 게시판-댓글
public interface ReplyService {

	//TODO [Service] 게시글-댓글 - 등록(register)
	Long register(ReplyDTO replyDTO);
	
	//TODO [Service] 게시글-댓글 - 게시판 번호 읽기(get)
	List<ReplyDTO> getList(Long board_num);
}
