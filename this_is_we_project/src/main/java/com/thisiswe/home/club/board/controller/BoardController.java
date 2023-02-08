package com.thisiswe.home.club.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/club/board/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 
public class BoardController {
	
	private final BoardService boardService;
	
	//연결 링크[게시판 목록]
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		
		log.info("=========================================================");
		log.info("====== BoardController.java => board_list.html 연결 ======");
		log.info("============ pageRequestDTO ============" + pageRequestDTO);
		
		log.info("=============== boardService.getList를 호출 ===============");
		model.addAttribute("result", boardService.getList(pageRequestDTO));		
		log.info("=========================================================");
	}
	
	//연결 링크[게시판 등록] - GET
	@GetMapping("/register")
	public void register() {
		
		log.info("=========================================================");
		log.info("==== BoardController.java => board_register.html 연결 ====");
		log.info("=========================================================");
	}
	
	//연결 링크[게시판 등록] - POST
	@PostMapping("/register")
	public String board_register(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
	
		log.info("=========================================================");
		log.info("==== BoardController.java => board_register.html 연결 ====");
		log.info("================ boardDTO ================> : " + boardDTO);
		
		Long boardNum = boardService.register(boardDTO);
		log.info("================ boardNum ================> : " + boardNum);
		redirectAttributes.addFlashAttribute("msg", boardNum );
		log.info("=========================================================");
		
		return "redirect:/club/board/board_list";
	}
	
	
	/*
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
	
	*/
	
}
