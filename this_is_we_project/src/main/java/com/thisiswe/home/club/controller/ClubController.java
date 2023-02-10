package com.thisiswe.home.club.controller;

import java.io.Console;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.dto.PageRequestDTO;
import com.thisiswe.home.club.repository.ClubRepository;
import com.thisiswe.home.club.service.ClubService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/club")
@Controller
@RequiredArgsConstructor
@Log4j2
public class ClubController {

	
	private final ClubService clubService;
	private final ClubRepository clubRepository;
	//목록 연결링크
	@GetMapping({"/list"})
	public String club_list(ClubDTO clubDTO, Model model ) {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_list.html 연결 =======");
		model.addAttribute("list", clubService.getList(clubDTO));
		log.info("=======================Get list end==================================");
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
	
	//[모임 등록]register.html에서 post타입으로 받아와서  모임 정보를 등록할때 사용됨
	@PostMapping("/list")
	public String club_register(ClubDTO clubDTO) {
		log.info("=========================================================");
		log.info("=========== ClubController.java => 데이터를 받은 후 DTO경유중 return : club_list페이지로 ==============");
		log.info("=========== register ClubDTO  : "+clubDTO+" =============");
		clubService.register(clubDTO); // 등록 페이지에서 받아온 데이터를 서비스로 보낸다.
		log.info("=========================================================");
		return "/club/club_list";
		
	}
	
	
	
	
	
	
	//상세 연결링크
	@GetMapping({"read"})
	public String club_read(Long Num ,Model model) {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_read.html 연결 =======");
		ClubDTO clubDTO = clubService.get(Num);
		model.addAttribute("readDTO", clubDTO);
		log.info("=========================================================");
		return "/club/club_read";
	}
	
	//수정 연결링크
	@GetMapping({"/modify"})
	public String club_modify(Long Num,Model model) {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_modify.html 연결 =======");
		ClubDTO clubDTO = clubService.get(Num);
		model.addAttribute("modifyDTO", clubDTO);
		System.out.println("컨트롤러 modify11");
		log.info("=========================================================");
		return "/club/club_modify";
	}
	
	
}

