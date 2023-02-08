package com.thisiswe.home.board.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisiswe.home.board.notice.dto.NoticeDTO;
import com.thisiswe.home.board.notice.dto.PageRequestDTO;
import com.thisiswe.home.board.notice.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/notice/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 
public class NoticeController {

	private final NoticeService noticeService;
	
	//연결 링크[게시판 목록]
		@GetMapping("/list")
		public String notice_list(PageRequestDTO pageRequestDTO, Model model) {
			
			log.info("=========================================================");
			log.info("===== noticeController.java => notice_list.html 연결 =====");
			
			model.addAttribute("result", noticeService.getList(pageRequestDTO));
			log.info("========= 출력 => " + noticeService.getList(pageRequestDTO));
			log.info("=========================================================");
			
			return "/notice/notice_list";
		}
		
		//연결 링크[게시판 등록] - GET
		@GetMapping("/register")
		public String notice_register() {
			
			log.info("=========================================================");
			log.info("=== noticeController.java => notice_register.html 연결 ===");
			log.info("=========================================================");
			
			return "/notice/notice_register";
		}
		
		//연결 링크[게시판 등록] - POST
		@PostMapping("/register")
		public String notice_register(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes) {
		
			log.info("=========================================================");
			log.info("=== noticeController.java => notice_register.html 연결 ===");
			log.info("=============== noticeDTO ===============> : " + noticeDTO);
			Long noticeNum = noticeService.register(noticeDTO);
			
			log.info("=============== noticeNum ===============> : " + noticeNum);
			redirectAttributes.addFlashAttribute("msg", noticeNum);
			log.info("=========================================================");
			
			return "redirect:/notice/notice_list";
		}
		
		/*
		 * //연결 링크[게시판 상세 조회, 게시글 수정] - GET
		 * 
		 * @GetMapping({"/read", "/modify"}) public void
		 * notice_read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long
		 * noticeNum, Model model) {
		 * 
		 * log.info("=========================================================");
		 * log.info("===== noticeController.java => notice_read.html 연결 =====");
		 * log.info("==== noticeController.java => notice_modify.html 연결 ====");
		 * 
		 * log.info("=============== noticeNum ===============> : " + noticeNum);
		 * NoticeDTO noticeDTO = noticeService.get(noticeNum);
		 * log.info("=============== noticeDTO ===============> : " + noticeDTO);
		 * 
		 * model.addAttribute("noticeDTO", noticeDTO);
		 * 
		 * log.info("=========================================================");
		 * 
		 * }
		 */
		
		//연결 링크[게시판 상세 조회, 게시글 수정] - GET
		@GetMapping({"/read", "/modify"})
		public void notice_read(Long noticeNum, Model model) {
			
			log.info("=========================================================");
			log.info("===== noticeController.java => notice_read.html 연결 =====");
			log.info("==== noticeController.java => notice_modify.html 연결 ====");
			
			log.info("=============== noticeNum ===============> : " + noticeNum);
			NoticeDTO noticeDTO = noticeService.get(noticeNum);
			log.info("=============== noticeDTO ===============> : " + noticeDTO);
			
			model.addAttribute("noticeDTO", noticeDTO);
			
			log.info("=========================================================");
			
		}
		
		/*
		 * //연결 링크[게시판 수정] - POST
		 * 
		 * @PostMapping("/modify") public String notice_modify(NoticeDTO
		 * noticeDTO, @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
		 * RedirectAttributes redirectAttributes) {
		 * 
		 * log.info("=========================================================");
		 * log.info("=============== noticeDTO ===============> : " + noticeDTO);
		 * 
		 * noticeService.modify(noticeDTO); redirectAttributes.addAttribute("page",
		 * requestDTO.getPage()); redirectAttributes.addAttribute("type",
		 * requestDTO.getType()); redirectAttributes.addAttribute("keyword",
		 * requestDTO.getKeyword()); redirectAttributes.addAttribute("noticeNum",
		 * noticeDTO.getNoticeNum());
		 * 
		 * log.info("=========================================================");
		 * 
		 * return "redirect:/notice/notice_modify"; }
		 */
		
		//연결 링크[게시판 수정] - POST
		@PostMapping("/modify")
		public String notice_modify(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes) {
			
			log.info("=========================================================");
			log.info("=============== noticeDTO ===============> : " + noticeDTO);
			
			noticeService.modify(noticeDTO);
			log.info("=========================================================");
			
			return "redirect:/notice/notice_modify";
		}
		
		//연결 링크[게시판 삭제] - POST
		@PostMapping("/remove")
		public String remove(long noticeNum, RedirectAttributes redirectAttributes) {
			
			log.info("=========================================================");
			log.info("=============== noticeNum ===============> : " + noticeNum);
			
			noticeService.remove(noticeNum);
			redirectAttributes.addFlashAttribute("msg", noticeNum);
			
			log.info("=========================================================");
			return "redirect:/notice/notice_list";			
		}
		
		
}
