package com.thisiswe.home.place.club.board.reply.service;

import java.util.List;
import java.util.stream.Collectors;

import com.thisiswe.home.place.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.place.club.board.reply.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import com.thisiswe.home.place.club.board.entity.Board;
import com.thisiswe.home.place.club.board.reply.entity.Reply;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

//TODO [ServiceImpl] 게시글-댓글
public class ReplyServiceImpl implements ReplyService{
	
	private final ReplyRepository replyRepository;
	
	//TODO [ServiceImpl] 게시글-댓글 : 등록
	@Override
	public Long register(ReplyDTO replyDTO) {
		
		Reply reply = replyDTOToEntity(replyDTO);
		replyRepository.save(reply);
		
		return reply.getBoardReplyNum();
	}

	//TODO [ServiceImpl] 게시글-댓글 : 목록
	@Override
	public List<ReplyDTO> getList(Long boardNum) {
		
		List<Reply> result = replyRepository.getRepliesByBoardOrderByBoardReplyNum(Board.builder().boardNum(boardNum).build());
		
		System.out.println("=========================================================");
		System.out.println("=================== result ===================> " + result);
		System.out.println("=========================================================");
		
		return result.stream().map(reply -> entityToReplyDTO(reply)).collect(Collectors.toList());
	}

	//TODO [ServiceImpl] 게시글-댓글 : 수정
	@Override
	public void modify(ReplyDTO replyDTO) {
		
		Reply reply = replyDTOToEntity(replyDTO);		
		System.out.println("=========================================================");
		System.out.println("==================== reply ====================> " + reply);
		System.out.println("=========================================================");
		
		replyRepository.save(reply);
		
	}

	//TODO [ServiceImpl] 게시글-댓글 : 삭제
	@Override
	public void remove(Long boardReplyNum) {
		
		System.out.println("=========================================================");
		System.out.println("============ boardReplyNum ============> " + boardReplyNum);
		System.out.println("=========================================================");
		replyRepository.deleteById(boardReplyNum);
	}
}
	