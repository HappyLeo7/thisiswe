package com.thisiswe.home.club.controller;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.service.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/club")
@Controller
@RequiredArgsConstructor
@Log4j2
public class ClubController {

	
	private final ClubService clubService;
	
	//목록 연결링크
	@GetMapping({"/list"})
	public String club_list(ClubEntity clubEntity ,Model model) {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_list.html 연결 =======");
		//TODO [모임목록]clublist를 출력하기 해서 사용
		model.addAttribute("lla", clubService.entitToDTO(clubEntity));
		log.info("=========================================================");
		return "/club/club_list";
	}
	
	//등록 연결링크
	@GetMapping({"/register"})
	public String club_register() {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_register.html 연결 =======");
		log.info("=========================================================");
		return "/club/club_register";
	}
	
	@PostMapping("/register")
	public String club_register(ClubDTO clubDTO) {
		log.info("=========================================================");
		log.info("=========== ClubController.java => 데이터를 받은 후 DTO경유중 return : club_list페이지로 ==============");
		log.info("=========== register ClubDTO  : "+clubDTO+" =============");
		clubService.register(clubDTO);
		log.info("=========================================================");
		return "/club/club_list";
		
	}
	
	//상세 연결링크
	@GetMapping({"read"})
	public String club_read() {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_read.html 연결 =======");
		log.info("=========================================================");
		return "/club/club_read";
	}
	
	//수정 연결링크
	@GetMapping({"/club_modify"})
	public String club_modify() {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_modify.html 연결 =======");
		log.info("=========================================================");
		return "/club/club_modify";
	}
	
	
}

