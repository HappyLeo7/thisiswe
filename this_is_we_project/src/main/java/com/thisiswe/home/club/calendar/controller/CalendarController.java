package com.thisiswe.home.club.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.club.calendar.dto.CalendarDTO;
import com.thisiswe.home.club.calendar.service.CalendarService;
import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.service.ClubService;

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
	
	@GetMapping({"/calendar"})
	public String calendar_list() {
		
		log.info("==== calendar list Contorller ====");
		log.info("==== /calendar list Contorller ====");
		
		return "/club/calendar/calendar_list";
	}
	
	//일정 등록페이지 연결
	@GetMapping({"/calendar/register/"})
	public String calendar_register(Long num ,Model model, ClubDTO cl) {
		log.info("==== getMapping calendar register() Contorller ====");
		log.info("num : "+num);
		ClubDTO clubDTO = clubService.get(num);
		log.info("clubDTO"+clubDTO);
		model.addAttribute("readDTO", clubDTO);
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
		return "redirect:/thisiswe/club/?num="+clubNum;
	}
	
	
}
