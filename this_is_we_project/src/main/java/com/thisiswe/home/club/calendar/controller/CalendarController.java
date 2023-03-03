package com.thisiswe.home.club.calendar.controller;

import com.thisiswe.home.club.calendar.service.CalendarService;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.club.calendar.dto.CalendarDTO;
import com.thisiswe.home.club.calendar.repository.CalendarRepository;
import com.thisiswe.home.club.dto.ClubDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/thisiswe/club/")
@Controller
@RequiredArgsConstructor
@Log4j2
public class CalendarController {

	@Autowired
	private ClubService clubService;
	
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private CalendarRepository calendarRepository;
	
	
	//일정 등록페이지 연결
	@GetMapping({"/calendar/register/"})
	public String calendar_register(Long num ,Model model, ClubDTO cl) {
		log.info("==== getMapping calendar register() Contorller ====");
		log.info("num : "+num);
		ClubDTO clubDTO = clubService.get(num); //데이터를 받아온다
		log.info("clubDTO"+clubDTO); 
		model.addAttribute("readDTO", clubDTO); //받아온 데이터를 web으로 보내주는 역할
		log.info("==== /getMapping calendar register() Contorller ====");
		return "club/calendar/calendar_register";
	}
	
	//[일정등록] 
	@PostMapping({"/calendar/register"})
	public String calendar_register(Long num,CalendarDTO calendarDTO) {
		log.info("==== postMappinig calendar register() Contorller ====");
		log.info("모임num : "+num);
		log.info("캘린더DTO : "+calendarDTO);
		log.info("캘린더DTOclubEntity : "+calendarDTO.getClubNum());
		log.info("캘린더DTOclubNum : "+calendarDTO.getClubNum().getClubNum());
		
		calendarService.register(calendarDTO);
		ClubEntity clubNum = calendarDTO.getClubNum();
		log.info("==== /postMappinig calendar register() Contorller ====");
		
		
		return "redirect:/thisiswe/club/?num="+clubNum.getClubNum();
	}
	
	
	//일정리스트에서 -> 일정상세페이지로 이동
	@GetMapping({"/calendar/read"})
	public String calendarRead(Long num, Model model) {
		log.info("==== getMappinig calendarRead() Contorller ====");
		CalendarDTO calendarDTO=calendarService.get(num); //1개의 일정 데이터를 가져옴
		log.info("calendarDTO : " + calendarDTO);
		model.addAttribute("calendarDTO",calendarDTO);
		model.addAttribute("calendarNum", calendarDTO.getClubNum().getClubNum());
		log.info("==== /getMappinig calendarRead() Contorller ====");
		return "club/calendar/calendar_read";
	}
	
	
	
	//일정 수정 페이지로 이동
	@GetMapping({"/calendar/modify"})
	public String calendarModify(Long num, Model model) {
		
		log.info("==== get calendar modify Contorller ====");
		
		CalendarDTO calendarDTO=calendarService.get(num); //모임 번호로 1개의 일정 데이터를 가져옴
		log.info("calendarDTO : " + calendarDTO);
		model.addAttribute("calendarDTO",calendarDTO);
		
		log.info("==== /get calendar modify Contorller ====");
		
		return "club/calendar/calendar_modify";
	}




	//일정 수정 처리
	@PostMapping({"/calendar/modify"})
	public String calendarModifyIng(CalendarDTO calendarDTO, Model model) {

		log.info("==== post calendar modify Contorller ====");

		

		//log.info("calendarDTO num : " + clubDTO);

		calendarDTO.setClubCalendarTime(calendarDTO.getClubCalendarTimeH()+":"+calendarDTO.getClubCalendarTimeM());
		log.info("calendarDTO : " + calendarDTO);
		

		CalendarDTO calendarDtoModify=calendarService.modify(calendarDTO); //1개의 일정 데이터를 가져옴
		log.info("calendarDTO : " + calendarDtoModify);
		model.addAttribute("calendarDTO",calendarDtoModify);
		
		log.info("==== / post calendar modify Contorller ====");
		
		return "club/calendar/calendar_read";
	}
	
	//일정 삭제 처리
	@DeleteMapping({"/calendar/remove/{calendarNum}"})
	public ResponseEntity<String> calnedarRemove(@PathVariable("calendarNum") Long calendarNum){
		log.info("=== delete controller calnedar remove ===");
		
		log.info("=== calendarNum : "+calendarNum);
		
		calendarRepository.deleteById(calendarNum);
		
		log.info("=== /delete controller calnedar remove ===");
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	
	
}
