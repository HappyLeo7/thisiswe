package com.thisiswe.home.board.free.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.board.free.dto.BoardDTO;

@Service

//TODO [Service] 게시판
public interface BoardService {
	
	//TODO [Service] 게시판 - 등록(register)
	Long register(BoardDTO dto);
	
	//TODO [Service] 게시판 - 읽기(get)
	BoardDTO get(Long board_num);

}
