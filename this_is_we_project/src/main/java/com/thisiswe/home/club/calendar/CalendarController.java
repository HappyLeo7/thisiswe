package com.thisiswe.home.club.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/thisiswe/club/")
@Controller
@RequiredArgsConstructor
@Log4j2
public class CalendarController {

	@GetMapping({"/calendar"})
	public String calendar_list() {
		
		log.info("==== calendarContorller ====");
		return "/club/calendar/calendar_list";
	}
	
	
	
}
