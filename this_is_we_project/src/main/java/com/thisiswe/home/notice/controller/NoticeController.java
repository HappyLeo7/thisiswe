package com.thisiswe.home.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 
public class NoticeController {

	/*
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
	*/		 
}