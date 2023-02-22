package com.thisiswe.home.club.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
							.boardCategory("모임수정")
							.boardTitle("클래스 수정함")
							.boardContent("수채화 클래스")
							.userId("user19")
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
	@Transactional
	public void testList() {
		
		PageRequestDTO pageRequestDTO = new PageRequestDTO();
		
		PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
		System.out.println("=========================================================");
		
		for(BoardDTO boardDTO : result.getDTOList()) {
			System.out.println(boardDTO);
		}
		
		System.out.println("=========================================================");
	}
	
	//TODO [SeviceTest] 게시판 - 수정(Modify)
	@Test
	public void testModify() {
		
		BoardDTO boardDTO = BoardDTO.builder()
									.boardNum(136L)
									.boardCategory("모임변경")
									.boardTitle("동아리 변경 관련 문의")
									.boardContent("oo동아리 1명 더 추가합니다.")
									.build();
		
		System.out.println("=========================================================");
		boardService.modify(boardDTO);
		System.out.println("=========================================================");
	}
	
	//TODO [SeviceTest] 게시판 - 삭제(Remove)
	@Test
	public void testRemove() {
		
		Long boardNum = 24L;
		System.out.println("=========================================================");
		System.out.println("============ " + boardNum + " 번이 삭제 되었습니다.============");
		System.out.println("=========================================================");
		boardService.removeWithReplies(boardNum);
		
	}	
}
