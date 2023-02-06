package com.thisiswe.home.club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/club")
@Controller
@RequiredArgsConstructor
@Log4j2
public class ClubController {

	
	//목록 연결링크
	@GetMapping({"/club_list"})
	public void club_list() {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_list.html 연결 =======");
		log.info("=========================================================");
	}
	
	//수정 연결링크
	@GetMapping({"/club_modify"})
	public void club_modify() {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_modify.html 연결 =======");
		log.info("=========================================================");
		
	}
	
	//상세 연결링크
	@GetMapping({"/club_read"})
	public void club_read() {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_read.html 연결 =======");
		log.info("=========================================================");
	}
	
	//등록 연결링크
	@GetMapping({"/club_register"})
	public void club_register() {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_register.html 연결 =======");
		log.info("=========================================================");
	}
}

