package com.thisiswe.home.board.free.service;

import com.thisiswe.home.board.free.dto.BoardDTO;

//TODO [Service] 게시판
public interface BoardService {
	
	//TODO [Service] 게시판 - 등록(register)
	Long register(BoardDTO dto);
	
	//TODO [Service] 게시판 - 읽기(get)
	BoardDTO get(Long board_num);

}