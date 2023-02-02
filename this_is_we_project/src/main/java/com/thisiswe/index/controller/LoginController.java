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
	@GetMapping({"/index"})
	public void index() {
		log.info("=======LoginController=======");
		log.info("index.html 연결");
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
	@GetMapping({"/test55"})
	public void test55() {
		log.info("=======LoginController=======");
		log.info("test55.html 연결");
		log.info("===========================");
	}
	@GetMapping({"/dw_class"})
	public void dw_class() {
		log.info("=======LoginController=======");
		log.info("dw_class.html 연결");
		log.info("===========================");
	}
	@GetMapping({"/narong_test2"})
	public void narong_test2() {
		log.info("=======LoginController=======");
		log.info("narong_test2.html 연결");
		log.info("===========================");
	}
	
	
}
