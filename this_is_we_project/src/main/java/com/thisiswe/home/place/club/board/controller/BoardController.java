package com.thisiswe.home.place.club.board.controller;

import com.thisiswe.home.place.club.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisiswe.home.place.club.board.dto.BoardDTO;
import com.thisiswe.home.place.club.board.dto.PageRequestDTO;
import com.thisiswe.home.place.club.board.entity.Board;
import com.thisiswe.home.place.club.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/club")
@Log4j2
@RequiredArgsConstructor
@Transactional

//TODO [Controller] 게시판
public class BoardController {
	
	@Autowired
	private final BoardService boardService;
	private final BoardRepository boardRepository;
	
	//TODO [Controller] 게시판 : 목록
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
	
	//TODO [Controller] 게시판 : 등록 - GET
	@GetMapping("/board/register")
	public String board_register() {
		
		log.info("=========================================================");
		log.info("==== BoardController.java => board_register.html 연결 ====");
		log.info("=========================================================");
		
		return "/club/board/board_register";	
	}
	
	//TODO [Controller] 게시판 : 등록 - POST
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
	
	//TODO [Controller] 게시판 : 상세 조회 - read, 조회수 증가
	@GetMapping("/board/read/{boardNum}")
	public String board_read(@PathVariable("boardNum") Long boardNum, Model model) {
		
		log.info("=========================================================");
		log.info("====== BoardController.java => board_read.html 연결 ======");
		log.info("================ boardNum ================> : " + boardNum);
		log.info("=========================================================");
		
		Board board = boardRepository.findById(boardNum).get();
		log.info("================ board ================> : " + board);
		
		Long boardView = board.getBoardView() + 1L;
		log.info("================ boardView ================> : " + boardView);
		log.info("================ boardUp ================> : " + board);
		
		
		BoardDTO boardDTO = BoardDTO.builder().boardView(boardView).build();
		log.info("================ boardDTO ================> : " + boardDTO);
					
		boardService.get(boardNum);			
		boardService.countView(board.getBoardNum(), boardDTO);
		
		model.addAttribute("boardDTO", board);
		log.info("======================= model-read ======================");
			
		return "club/board/board_read";
	}
	
	//TODO [Controller] 게시판 : 수정 - get
	@GetMapping("board/modify")
	public String board_modify(Long boardNum, Model model) {
		
		log.info("=========================================================");
		log.info("===== BoardController.java => board_modify.html 연결 =====");
		log.info("================ boardNum ================> : " + boardNum);
		
		BoardDTO boardDTO =boardService.get(boardNum);
		log.info("========= boardNum =========> : " + boardDTO.getBoardNum());
		
		model.addAttribute("boardDTO", boardDTO);
		
		log.info("modify boardDTO : "+boardDTO);
		log.info("========================= model-modify ========================");
		
		return "club/board/board_modify";
	}
	
	//TODO [Controller] 게시판 : 수정 - post
	@PostMapping("/board/modify")
	public String String_modify(BoardDTO boardDTO,
								@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
								RedirectAttributes redirectAttributes) {
		
		log.info("=========================================================");
		log.info("================ boardDTO ================> : " + boardDTO);
		
		boardService.modify(boardDTO);
		
		redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
		redirectAttributes.addAttribute("type", pageRequestDTO.getType());
		redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());
		redirectAttributes.addAttribute("boardNum", boardDTO.getBoardNum());
		
		log.info("=========================================================");
			
		return "/club/board/board_read/{boardNum}";
	}
	
	//TODO [Controller] 게시판 : 삭제 - post
	@PostMapping("/board/remove")
	public String remove(long boardNum, RedirectAttributes redirectAttributes) {
		
		log.info("=========================================================");
		log.info("================ boardNum ================> : " + boardNum);
		
		boardService.remove(boardNum);
		
		redirectAttributes.addFlashAttribute("msg", boardNum);
		log.info("=========================================================");
		
		return "redirect:/club/board/list";
	}
	
}
