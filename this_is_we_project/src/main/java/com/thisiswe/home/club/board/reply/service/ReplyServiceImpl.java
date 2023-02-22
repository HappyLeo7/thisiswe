package com.thisiswe.home.club.board.reply.service;

import java.util.List;
import java.util.stream.Collectors;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.board.reply.repository.ReplyRepository;
import com.thisiswe.home.club.board.repository.BoardRepository;
import com.thisiswe.home.club.board.service.BoardService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

//TODO [ServiceImpl] 게시글-댓글
public class ReplyServiceImpl implements ReplyService{
	
	private final ReplyRepository replyRepository;
	private final BoardRepository boardRepository;
	
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
		
	/*	List<Reply> result = replyRepository.getRepliesByBoardOrderByBoardReplyNum(Board.builder().boardNum(boardNum).build()); */
		List<Reply> result = replyRepository.findByBoardNum(boardRepository.findById(boardNum).get());
		
		System.out.println("[ReplyServiceImpl][list]=================================");
		System.out.println("[ReplyServiceImpl][list] result ====> :: " + result);
		System.out.println("/[ReplyServiceImpl][list]================================");
		
		return result.stream().map(i -> entityToReplyDTO(i)).collect(Collectors.toList());
	}

	//TODO [ServiceImpl] 게시글-댓글 : 수정
	@Override
	public void modify(ReplyDTO replyDTO) {		
		
		System.out.println("[ReplyServiceImpl][modify]===============================");
		System.out.println("[ReplyServiceImpl][modify] replyDTO =====> :: " + replyDTO);
		System.out.println("/[ReplyServiceImpl][modify]==============================");
		
		replyRepository.save(replyDTOToEntity(replyDTO));
	}

	//TODO [ServiceImpl] 게시글-댓글 : 삭제
	@Override
	public void remove(Long boardReplyNum) {
		
		System.out.println("[ReplyServiceImpl][modify]===============================");
		System.out.println("[ReplyServiceImpl][modify] boardReplyNum => :: " + boardReplyNum);
		System.out.println("/[ReplyServiceImpl][modify]==============================");
		
		replyRepository.deleteById(boardReplyNum);
	}
}
	