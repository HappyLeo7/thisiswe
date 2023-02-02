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
public class indexController {

	//index1 연결
	@GetMapping({""})
	public String main() {
		log.info("======MainController=======");
		log.info("****index.html 연결****");
		log.info("===========================");
		return "redirect:/login/index";
		
	}
	
}
