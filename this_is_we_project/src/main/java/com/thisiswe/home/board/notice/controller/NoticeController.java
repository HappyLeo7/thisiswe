package com.thisiswe.home.board.notice.controller;

import com.thisiswe.home.board.notice.service.NoticeService;
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

	private NoticeService noticeService;
}
