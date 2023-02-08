package com.thisiswe.home.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisiswe.home.notice.dto.NoticeDTO;
import com.thisiswe.home.notice.dto.PageRequestDTO;
import com.thisiswe.home.notice.service.NoticeService;

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
}