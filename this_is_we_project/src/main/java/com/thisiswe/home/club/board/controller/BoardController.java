package com.thisiswe.home.club.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.repository.BoardRepository;
import com.thisiswe.home.club.board.service.BoardService;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/thisiswe")
@Log4j2
@RequiredArgsConstructor
@Transactional

//TODO [Controller] 게시판
public class BoardController {

	@Autowired
	private final BoardService boardService;
	private final BoardRepository boardRepository;

	// TODO [Controller] 게시판 : 목록
	@GetMapping({ "/club/board" })
	public String board_list(PageRequestDTO pageRequestDTO, Model model, Long num) {

		log.info("====== BoardController.java => board_list.html 연결 ======");

		log.info("모임 번호  :  " + num);
		log.info("====== pageRequestDTO : " + pageRequestDTO);

		log.info("====== boardService.getList를 호출 ");
		model.addAttribute("result", boardService.getList(pageRequestDTO, num));
		log.info(" board result :  "+model.addAttribute(boardService.getList(pageRequestDTO, num)));
		model.addAttribute("clubNum",num);
		log.info("====== /BoardController.java => board_list.html 연결 ======");

		return "/club/board/board_list";
	}

	// TODO [Controller] 게시판 : 등록 - GET
	@GetMapping("/club/board/register")
	public String board_register(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model, Long num) {

		log.info("============== [controller] board-register ============");
		log.info("==== BoardController.java => board_register.html 연결 ====");
		log.info("==== clubNum : " + num);
		log.info("유저 아이디 userDetails.getUsername() :" + userDetails.getUsername());
		log.info("userDetails 접속된 유저 ID : " + model.addAttribute("user", userDetails.getUsername()));
		model.addAttribute("clubNum",num);

		log.info("============== /[controller] board-register ============");

		return "/club/board/board_register";
	}

	// TODO [Controller] 게시판 : 등록 - POST
	@PostMapping("/club/board/register")
	public String board_register(BoardDTO boardDTO, RedirectAttributes redirectAttributes, Model model,
			PageRequestDTO pageRequestDTO, Long num) {

		log.info("==== post => board_register.html 연결 ====");
		log.info("==== boardDTO : " + boardDTO);
		boardDTO.setClubNum(num);
		// TODO [Controller] 게시판 : 등록 - boardService에 등록
		Long boardNum = boardService.register(boardDTO);
		log.info("================ boardNum ================> : " + boardNum);
		redirectAttributes.addFlashAttribute("msg", boardNum);
		log.info("===========pageRequestDTO===================" + pageRequestDTO);
		model.addAttribute("result", boardService.getList(pageRequestDTO, num));

		return "/club/board/board_list";
	}

	// TODO [Controller] 게시판 : 상세 조회 - read, 조회수 증가
	@GetMapping({ "/club/board/read" })
	public String board_read(Long boardNum, Model model, PageRequestDTO pageRequestDTO) {

		log.info("[controller] ================ String read ===============");
		log.info("[controller] BoardController.java => board_read.html 연결 ");
		log.info(" boardNum :: " + boardNum);

		Board board = boardRepository.findById(boardNum).get();
		log.info(" board  :: " + board);
		// boardRepository.boardView(boardNum);

		Long boardView = board.getBoardView() + 1L;
		log.info(" boardView :: " + boardView);

		BoardDTO boardDTO = BoardDTO.builder().boardView(boardView).build();

		boardService.get(boardNum);
		boardService.countView(board.getBoardNum(), boardDTO);

		model.addAttribute("boardDTO", board);

		log.info("pageRequestDTO : " + pageRequestDTO);
		model.addAttribute("result", boardService.getList(pageRequestDTO , boardNum));

		log.info("[/controller] =============== String read ===============");

		return "/club/board/board_read";
	}

	// TODO [Controller] 게시판 : 수정 - get
	@GetMapping({ "/club/board/modify" })
	public String board_modify(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long boardNum,
			Model model) {

		log.info("[controller] ============= String modify : get ============");
		log.info("[controller] BoardController.java => board_modify.html 연결 ");
		log.info("[controller] boardNum :: " + boardNum);

		BoardDTO boardDTO = boardService.get(boardNum);
		log.info("[controller] boardDTO.getBoardNum :: " + boardDTO.getBoardNum());

		model.addAttribute("boardDTO", boardDTO);

		log.info("[controller] model-read boardDTO :: " + boardDTO);

		log.info("pageRequestDTO : " + pageRequestDTO);
		model.addAttribute("");

		log.info("[controller] ============= /String modify : get ============");

		return "/club/board/board_modify";
	}

	// TODO [Controller] 게시판 : 수정 - post
	@PostMapping({ "/club/board/modify" })
	public String String_modify(BoardDTO boardDTO, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
			RedirectAttributes redirectAttributes) {

		log.info("[controller] ============= String modify : post ===========");
		log.info("[controller] model-modify boardDTO :: " + boardDTO);

		boardService.modify(boardDTO);

		redirectAttributes.addAttribute("boardNum", boardDTO.getBoardNum());
		redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
		redirectAttributes.addAttribute("type", pageRequestDTO.getType());
		redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());

		log.info(" boardDTO :: " + boardDTO);
		log.info("[controller] ============= String modify : post ===========");

		/* return "/club/board/board_read"; */
		return "redirect:/thisiswe/club/board/read";
	}

	// TODO [Controller] 게시판 : 삭제 - post
	@PostMapping({ "/club/board/remove" })
	public String remove(long boardNum, RedirectAttributes redirectAttributes) {

		log.info("=========================================================");
		log.info("================ boardNum ================> : " + boardNum);

		boardService.removeWithReplies(boardNum);

		redirectAttributes.addFlashAttribute("msg", boardNum);
		log.info("=========================================================");

		return "redirect:/thisiswe/club/board";
	}

}