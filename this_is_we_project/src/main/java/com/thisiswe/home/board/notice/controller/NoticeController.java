package com.thisiswe.home.board.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.board.notice.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/notice/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 
public class NoticeController {

	private NoticeService noticeService;
}
