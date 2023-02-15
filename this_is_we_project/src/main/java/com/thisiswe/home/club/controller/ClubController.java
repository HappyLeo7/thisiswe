package com.thisiswe.home.club.controller;


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

@RequestMapping("/thisiswe")
@Controller
@RequiredArgsConstructor
@Log4j2
public class ClubController {

	
	private final ClubService clubService;
	private final ClubRepository clubRepository;
	//목록 연결링크
	@GetMapping({"/club"})
	public String club_list(PageRequestDTO pageRequestDTO, ClubDTO clubDTO, Model model ) {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_list.html 연결 =======");
		model.addAttribute("list", clubService.getList(clubDTO)); //그냥 리스트 불러오는 코드
		//model.addAttribute("result", clubService.getPageList(pageRequestDTO));
		//model.addAttribute("list", "model 확인");
		
		
		log.info("커몬 : "+ (Object) clubService.getPageList(pageRequestDTO));
		
		
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
	@PostMapping("/club")
	public String club_register(ClubDTO clubDTO,Model model) {
		log.info("=========================================================");
		log.info("=========== ClubController.java => 데이터를 받은 후 DTO경유중 return : club_list페이지로 ==============");
		log.info("=========== register ClubDTO  : "+clubDTO+" =============");
		clubService.register(clubDTO); // 등록 페이지에서 받아온 데이터를 서비스로 보낸다.
		model.addAttribute("list", clubService.getList(clubDTO)); //그냥 리스트 불러오는 코드
		log.info("=========================================================");
		return "/club/club_list";
		
	}
	
	
	
	
	
	
	//상세페이지 연결링크
	@GetMapping({"/club/"})
	public String club_read(Long Num ,Model model) {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_read.html 연결 =======");
		ClubDTO clubDTO = clubService.get(Num);
		model.addAttribute("readDTO", clubDTO);
		log.info("=========================================================");
		return "/club/club_read";
	}
	
	//수정 페이지 불러오는 연결링크
	@GetMapping({"/modify"})
	public String club_modify(Long Num,Model model) {
		log.info("=========================================================");
		log.info("======= ClubController.java => club_modify.html 연결 =======");
		ClubDTO clubDTO = clubService.get(Num);
		model.addAttribute("modifyDTO", clubDTO);
		log.info("========= /ClubController.java => club_modify.html 연결 ======");
		return "/club/club_modify";//포워드
	}
	
	//club데이터 수정매서드
	@PostMapping({"/read"})
	public String club_modify(ClubDTO clubDTO) {
		log.info("==============================");
		log.info("======= ClubController => post타입 modify ==============");
		// 수정 코드 작성
		log.info("수정 club : "+clubDTO);
		clubService.modify(clubDTO);
		
		
		log.info("========/ post 타입 club_modify ======================");
		return "redirect:/thisiswe/club/?Num="+clubDTO.getClubNum();
	}
	
	
	//삭제버튼 클릭시 삭제됨
	@PostMapping({"/remove"})
	public String clubRemove(ClubDTO clubDTO) {
		
		log.info("========ClubController ==> clubRemove 매서드 =====");
		log.info("======== 모임 "+clubDTO+"번호 =====");
		clubRepository.deleteById(clubDTO.getClubNum());
		log.info(clubDTO.getClubNum()+"번 "+clubDTO.getClubName()+"모임이 삭제되었습니다.");
		return "redirect:/club/list";
	}
	
	
}

