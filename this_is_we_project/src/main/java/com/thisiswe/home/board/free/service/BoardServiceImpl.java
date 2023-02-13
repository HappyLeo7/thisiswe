package com.thisiswe.home.board.free.service;

import com.thisiswe.home.board.free.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2

//TODO [ServiceImpl] 게시판
public class BoardServiceImpl implements BoardService {

	//private final BoardService boardService;
	//private final ReplyService replyService;
	
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
