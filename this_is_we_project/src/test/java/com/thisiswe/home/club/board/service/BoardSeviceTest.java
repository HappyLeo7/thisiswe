package com.thisiswe.home.club.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.dto.PageResultDTO;

@SpringBootTest

//TODO [SeviceTest] 게시판
public class BoardSeviceTest {

	@Autowired
	private BoardService boardService;
	
	//TODO [SeviceTest] 게시판 - 등록(register)
	@Test
	public void testRegister() {
		
		BoardDTO boardDTO = BoardDTO.builder()
							.boardCategory("모임삭제")
							.boardTitle("클래스 삭제하려고 합니다")
							.boardContent("비누 클래스")
							.userId("user30")
							.build();
		
		Long boardNum = boardService.register(boardDTO);
		System.out.println("=========================================================");
		System.out.println("================= boardNum =================> " + boardNum);
		System.out.println("=========================================================");
	}
	
	//TODO [SeviceTest] 게시판 - 번호 불러오기(get)
	@Test
	public void testGet() {
		
		Long boardNum = 1L;
		BoardDTO boardDTO = boardService.get(boardNum);
		System.out.println("=========================================================");
		System.out.println("================= boardDTO =================> " + boardDTO);
		System.out.println("=========================================================");
	}
	
	//TODO [SeviceTest] 게시판 - 목록(list)
	@Test
	public void testList() {
		
		PageRequestDTO pageRequestDTO = new PageRequestDTO();
		
		PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
		System.out.println("=========================================================");
		
		for(BoardDTO boardDTO : result.getDTOList()) {
			System.out.println(boardDTO);
		}
		
		System.out.println("=========================================================");
	}
	
	
}
