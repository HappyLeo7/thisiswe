package com.thisiswe.home.club.board.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.club.board.dto.BoardDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

//TODO [ServiceImpl] 게시판
public class BoardServiceImpl implements BoardService {
		
	/*
	 * @Autowired private final BoardService boardService; private final
	 * ReplyService replyService;
	 */
	
	@Override
	public Long register(BoardDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO get(Long board_num) {
		// TODO Auto-generated method stub
		return null;
	}

}
