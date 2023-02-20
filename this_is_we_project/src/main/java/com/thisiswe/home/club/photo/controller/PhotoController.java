package com.thisiswe.home.club.photo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.club.photo.service.PhotoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/thisiswe/club")
@Controller
@RequiredArgsConstructor
@Log4j2
public class PhotoController {

	private PhotoService photoService;
	
	
	//사진 등록 페이지
	@GetMapping("/register")
	public String photoRegisterPage() {
		return "/club/photo/photo_register";
	}
	
	//사진등록 처리
	@PostMapping("/register")
	public String postPhotoRegister() {
		log.info("===== photo post register controller =====");
		
		//photoService.register();
		
		log.info("===== /photo post register controller =====");
		return null;
	}
	
	//사진첩 목록페이지 연결링크
	@GetMapping({"/photo"})
	public String photoListPage() { 
		log.info("====== photo controller list ======");
		
		
		
		log.info("====== /photo controller list ======");
		
		return "/club/photo/photo_list";
	}
	
}
