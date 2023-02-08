package com.thisiswe.home.club.board.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.dto.PageResultDTO;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

//TODO [ServiceImpl] 게시판
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	//TODO [ServiceImpl] 게시판 - 등록(register)
	public Long register(BoardDTO boardDTO) {
		
		log.info("=========================================================");
		log.info("================ boardDTO ================> : " + boardDTO);
		log.info("=========================================================");
		
		Board board = boardDTOToEntity(boardDTO);
		boardRepository.save(board);
		
		return board.getBno();
	}

	@Override
	public BoardDTO get(Long boarNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
