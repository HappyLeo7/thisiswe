package com.thisiswe.home.board.reply.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thisiswe.home.board.reply.dto.ReplyDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

//TODO [ServiceImpl] 게시글-댓글
public class ReplyServiceImpl implements ReplyService{
	
	@Override
	public Long register(ReplyDTO replyDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReplyDTO> getList(Long board_num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//private final ReplyService replyService;

}