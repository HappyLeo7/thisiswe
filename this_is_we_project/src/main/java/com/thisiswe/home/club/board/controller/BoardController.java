package com.thisiswe.home.club.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/club/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 게시판
public class BoardController {
	
	private final BoardService boardService;
	
	//연결 링크[게시판 목록]
	@GetMapping("/board/list")
	public String board_list(PageRequestDTO pageRequestDTO, Model model) {
		
		log.info("=========================================================");
		log.info("====== BoardController.java => board_list.html 연결 ======");
		log.info("=========== pageRequestDTO ===========>" + pageRequestDTO);
		
		log.info("=============== boardService.getList를 호출 ===============");
		model.addAttribute("result", boardService.getList(pageRequestDTO));		
		log.info("=========================================================");
		
		return "/club/board/board_list";	
	}
	
	//연결 링크[게시판 등록] - GET
	@GetMapping("/board/register")
	public void register() {
		
		log.info("=========================================================");
		log.info("==== BoardController.java => board_register.html 연결 ====");
		log.info("=========================================================");
	}
	
	//연결 링크[게시판 등록] - POST
	@PostMapping("/board/register")
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
	
	//연결 링크[게시판 상세 조회, 수정] - GET
	@GetMapping({"/board/read", "board/modify"})
	public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long boardNum, Model model) {
		
		log.info("=========================================================");
		log.info("================ boardNum ================> : " + boardNum);
		log.info("=========================================================");
		
		BoardDTO boardDTO = boardService.get(boardNum);
		log.info("================ boardDTO ================> : " + boardDTO);
		
		model.addAttribute("boardDTO", boardDTO);
	}
		
}
