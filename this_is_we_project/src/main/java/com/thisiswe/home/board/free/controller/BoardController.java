package com.thisiswe.home.board.free.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.board.free.dto.BoardDTO;
import com.thisiswe.home.board.free.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 
public class BoardController {
	
	private final BoardService boardService;
	
	//연결 링크[게시판 목록]
	@GetMapping("/list")
	public String board_list() {
		
		log.info("=========================================================");
		log.info("====== BoardController.java => board_list.html 연결 ======");
		log.info("=========================================================");
		
		return "/board/board_list";
	}
	
	//연결 링크[게시판 등록] - GET
	@GetMapping("/register")
	public String board_register() {
		
		log.info("=========================================================");
		log.info("==== BoardController.java => board_register.html 연결 ====");
		log.info("=========================================================");
		
		return "/board/board_register";
	}
	
	//연결 링크[게시판 등록] - POST
	@PostMapping("/register")
	public String board_register(BoardDTO boardDTO) {
	
		log.info("=========================================================");
		log.info("==== BoardController.java => board_register.html 연결 ====");
		log.info("================ boardDTO ================> : " + boardDTO);
		log.info("=========================================================");
		
		return "/board/board_list";
	}
	
	//연결 링크[게시판 상세 조회] - GET
	@GetMapping("/read")
	public String board_read() {
		
		log.info("=========================================================");
		log.info("====== BoardController.java => board_read.html 연결 ======");
		log.info("=========================================================");
		
		return "/board/board_read";
	}
	
	//연결 링크[게시판 수정] - GET
	@GetMapping("/modify")
	public String board_modify() {
		
		log.info("=========================================================");
		log.info("===== BoardController.java => board_modify.html 연결 =====");
		log.info("=========================================================");
		
		return "/board/board_modify";
	}
	
	
	
}
