package com.thisiswe.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

//연결 이노테이션
@Controller
@RequestMapping("/login")
@Log4j2
@RequiredArgsConstructor
public class indexController {

	//index1 연결
	@GetMapping({"/index2","/index3"})
	public void index() {
		log.info("index2,3.html 연결");
	}
}
