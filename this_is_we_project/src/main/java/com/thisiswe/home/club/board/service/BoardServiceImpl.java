package com.thisiswe.home.club.board.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.dto.PageResultDTO;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.repository.BoardRepository;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

//TODO [ServiceImpl] 게시판
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	//TODO [ServiceImpl] 게시판 - 등록(register)
	@Override
		public Long register (BoardDTO boardDTO) {
			
			log.info("=========================================================");
			log.info("================ boardDTO ================> : " + boardDTO);
			log.info("=========================================================");
			
			Board board = boardDTOToEntity(boardDTO);
			boardRepository.save(board);
			
			return board.getBoardNum();
		}
	
	//TODO [ServiceImpl] 게시판 - boardNum 불러오기(get)
	@Override
	public BoardDTO get(Long boardNum) {
		
		/*
		 * Object result = boardRepository.getBoardByBoardNum(boardNum); Object[] arr =
		 * (Object[]) result;
		 */
				
		/* return entityToBoardDTO((Board)arr[0], (UserEntity)arr[1], (Long)arr[2]); */
		return null;
	}
	
	//TODO [ServiceImpl] 게시판 - boardNum 불러오기(get)
	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

		log.info("=========================================================");
		log.info("========== pageRequestDTO ==========> : " + pageRequestDTO);
		log.info("=========================================================");
		
		Function<Object[], BoardDTO> func = (en ->
									entityToBoardDTO((Board)en[0], (UserEntity)en[1], (Long)en[2]));
										
		Page<Object[]> result = boardRepository.searchPage(
												pageRequestDTO.getType(),
												pageRequestDTO.getKeyword(),
												pageRequestDTO.getPageable(Sort.by("boardNum").descending()));								
		
		return new PageResultDTO<>(result, func);
	}

	//TODO [ServiceImpl] 게시판 - 수정(modify)
	@Transactional
	@Override
	public void modify(BoardDTO boardDTO) {

		Board board = boardRepository.getById(boardDTO.getBoardNum());
		
		if(board != null) {
			board.change(boardDTO.getBoardCategory(), boardDTO.getBoardTitle(), boardDTO.getBoardContent());
		}
		
		boardRepository.save(board);
	}

	//TODO [ServiceImpl] 게시판 - 삭제(remove)
	@Transactional
	@Override
	public void remove(Long boardNum) {
		boardRepository.deleteById(boardNum);
	}
	
}
