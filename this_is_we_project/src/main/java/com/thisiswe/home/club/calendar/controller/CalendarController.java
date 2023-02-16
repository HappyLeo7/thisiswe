package com.thisiswe.home.club.calendar.controller;

import com.thisiswe.home.club.calendar.service.CalendarService;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.club.calendar.dto.CalendarDTO;
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
	
	
	
	//일정 등록페이지 연결
	@GetMapping({"/calendar/register/"})
	public String calendar_register(Long num ,Model model, ClubDTO cl) {
		log.info("==== getMapping calendar register() Contorller ====");
		log.info("num : "+num);
		ClubDTO clubDTO = clubService.get(num); //데이터를 받아온다
		log.info("clubDTO"+clubDTO); 
		model.addAttribute("readDTO", clubDTO); //받아온 데이터를 web으로 보내주는 역할
		log.info("==== /getMapping calendar register() Contorller ====");
		return "/club/calendar/calendar_register";
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
		
		
		return "redirect:/thisiswe/club/?Num="+clubNum.getClubNum();
	}
	//등록페이지에서 -> 모임상세페이지(일정리스트)로 이동
	@GetMapping({"/calendar/"})
	public String calendarRead(Long Num) {
		log.info("==== getMappinig calendarRead() Contorller ====");
		CalendarDTO calendarDTO=calendarService.get(Num); //1개의 일정 데이터를 가져옴
		log.info("calendarDTO : " + calendarDTO);
		log.info("==== /getMappinig calendarRead() Contorller ====");
		return "/club/calendar/calendar_read";
	}
	
	@GetMapping({"/calendar"})
	public String calendar() {
		
		log.info("==== calendar list Contorller ====");
		log.info("==== /calendar list Contorller ====");
		
		return "/club/calendar/calendar_list";
	}
	
	
	
}
