package com.thisiswe.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

//연결 이노테이션
@Controller
@RequestMapping("/")
@Log4j2
@RequiredArgsConstructor
public class MainController {

	//index1 연결
	@GetMapping({"/basicindex"})
	public void index() {
		log.info("****basicindex.html 연결****");
	}
	
}
