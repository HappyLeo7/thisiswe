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
public class LoginController {

	//index1 연결
	@GetMapping({"/test1"})
	public void test1() {
		log.info("=======LoginController=======");
		log.info("test1.html 연결");
		log.info("===========================");
	}
	@GetMapping({"/test2"})
	public void test2() {
		log.info("=======LoginController=======");
		log.info("test2.html 연결");
		log.info("===========================");
	}
	@GetMapping({"/test3"})
	public void test3() {
		log.info("=======LoginController=======");
		log.info("test3.html 연결");
		log.info("===========================");
	}
	@GetMapping({"/dw_class"})
	public void dw_class() {
		log.info("=======LoginController=======");
		log.info("dw_class.html 연결");
		log.info("===========================");
	}
	
	
}
