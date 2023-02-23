package com.thisiswe.home.club.photo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.photo.dto.PhotoDTO;
import com.thisiswe.home.club.photo.entity.PhotoEntity;
import com.thisiswe.home.club.photo.service.PhotoService;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/thisiswe/club/photo")
@Controller
@RequiredArgsConstructor
@Log4j2
public class PhotoController {

	
	private final PhotoService photoService;
	
	
	//사진 등록 페이지
	@GetMapping("/register")
	public String photoRegisterPage(ClubDTO clubDTO, Model model, Long num,@AuthenticationPrincipal UserDetailsImpl userDetails) {
		log.info("===== photo get register controller =====");
		
		log.info("사진등록 모임 번호 : "+num);
		model.addAttribute("user",userDetails.getUsername());
		log.info("사진등록 등록자 아이디 : "+model.addAttribute("user"));
		model.addAttribute("clubNum", num);
		
		log.info("===== /photo get register controller =====");
		
		return "/club/photo/photo_register";
	}
	
	//사진등록 처리
	@PostMapping("/register")
	public String postPhotoRegister(PhotoDTO photoDTO,RedirectAttributes redirectAttributes, MultipartFile file,ClubDTO num) throws Exception{
		log.info("===== photo post register controller =====");
		
		//log.info(" photoDTO  : "+photoDTO);
		//log.info(" redirectAttributes  : "+redirectAttributes);
		log.info(" 이미지 file 정보  : "+file);
		log.info(" 이미지 photoDTO 정보  : "+photoDTO);
		log.info(" 모임DTO 정보  : "+num);
		
		photoService.photoRegister(photoDTO, file, num);
		
		log.info("===== /photo post register controller =====");
		return "redirect:/thisiswe/club/photo/?clubNum="+num.getClubNum();
	}
	
	//사진첩 목록페이지 연결링크
	@GetMapping({"/"})
	public String photoListPage(Long clubNum, Model model) { 
		log.info("====== photo controller list ======");
		log.info("clubNum :  " +clubNum);
		model.addAttribute("clubNum",clubNum);
		model.addAttribute("photoDTOList", photoService.getPhotoList(clubNum));
		log.info("photoDTOList 값 : "+model.addAttribute("photoDTOList"));
		
		
		//------------------------------------
		
		
		
		
		//------------------------------------
		
		
		
		
		
		
		
		
		
		log.info("====== /photo controller list ======");
		
		
		return "/club/photo/photo_list";
	}
	
}
