package com.thisiswe.home.place.club.board.service;

import java.util.function.Function;

import com.thisiswe.home.place.club.board.reply.repository.ReplyRepository;
import com.thisiswe.home.place.club.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thisiswe.home.place.club.board.dto.BoardDTO;
import com.thisiswe.home.place.club.board.dto.PageRequestDTO;
import com.thisiswe.home.place.club.board.dto.PageResultDTO;
import com.thisiswe.home.place.club.board.entity.Board;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional

//TODO [ServiceImpl] 게시판
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	private final ReplyRepository replyRepository;
	
	//TODO [ServiceImpl] 게시판 - 등록(register)
	@Override
		public Long register (BoardDTO boardDTO) {
			
			log.info("================= ServiceImpl register =================");
			log.info("================ boardDTO ================> : " + boardDTO);
			log.info(boardDTO);
			log.info("================= ServiceImpl register =================");
			
			Board board = boardDTOToEntity(boardDTO);
			boardRepository.save(board);
			log.info("=================== board ===================> : " + board);
			log.info(board);
			log.info("================= ServiceImpl register =================");
			
			return board.getBoardNum();
		}
	
	//TODO [ServiceImpl] 게시판 - boardNum 불러오기(get)
	@Override
	public BoardDTO get(Long boardNum) {

		log.info("==================== ServiceImpl get ====================");
		log.info("================ boardNum ================> : " + boardNum);
		Object result = boardRepository.getBoardByBoardNum(boardNum); 
		log.info("================== result ==================> : " + result);
		
		Object[] arr = (Object[]) result;
		log.info("===================== arr =====================> : " + arr);		
		log.info("==================== ServiceImpl get ====================");
		
		return entityToBoardDTO((Board)arr[0], (UserEntity)arr[1], (Long)arr[2]);
	}
	
	//TODO [ServiceImpl] 게시판 - 페이지 목록(list)
	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

		log.info("================ ServiceImpl Page getList ================");
		log.info("========== pageRequestDTO ==========> : " + pageRequestDTO);
		log.info("================ ServiceImpl Page getList ================");
		
		Function<Object[], BoardDTO> func = (en ->
									entityToBoardDTO((Board)en[0], (UserEntity)en[1], (Long)en[2]));
										
		Page<Object[]> result = boardRepository.searchPage(
												pageRequestDTO.getType(),
												pageRequestDTO.getKeyword(),
												pageRequestDTO.getPageable(Sort.by("boardNum").descending()));								
		
		return new PageResultDTO<>(result, func);
	}

	//TODO [ServiceImpl] 게시판 - 수정(modify)
	@Override
	public void modify(BoardDTO boardDTO) {

		Board board = boardRepository.getById(boardDTO.getBoardNum());
		
		if(board != null) {
			board.change(boardDTO.getBoardCategory(), boardDTO.getBoardTitle(), boardDTO.getBoardContent());
		}
		
		boardRepository.save(board);
	}

	//TODO [ServiceImpl] 게시판 - 삭제(remove)
	@Override
	public void removeWithReplies(Long boardNum) {
		
		boardRepository.deleteById(boardNum);
		replyRepository.deleteByBoardNum(boardNum);
	}
	
	//TODO [ServiceImpl] 게시판 - 조회수 증가(중복 제외)
	/* @Override
	public void countView(Long boardNum, BoardDTO boardDTO) {
		Board board = boardRepository.findById(boardNum).orElseThrow((() ->
									new IllegalStateException("게시글이 존재하지 않습니다.")));
		
		board.countView(boardDTO.getBoardView());
	}*/

	@Override
	public Long countView(Long boardNum, BoardDTO boardDTO) {
		
		return this.boardRepository.boardView(boardNum);
	}
}
