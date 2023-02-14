package com.thisiswe.home.club.calendar.service;


import com.thisiswe.home.club.calendar.dto.CalendarDTO;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;

import lombok.extern.log4j.Log4j2;


public interface CalendarService {
	
	
	//일정등록
	Long register(CalendarDTO calendarDTO);
	
	
	//dto -> entity
	default CalendarEntity dtoToEntity(CalendarDTO calendarDTO) {
		System.out.println(".... calendarEntity interface dtoToEntity ....");
		
		
		CalendarEntity calendarEntity = CalendarEntity.builder()
				.clubCalendarTitle(calendarDTO.getClubCalendarTitle())
				.clubCalendarContent(calendarDTO.getClubCalendarContent())
				.clubCalendarDate(calendarDTO.getClubCalendarDate())
				.clubCalendarTime(calendarDTO.getClubCalendarTime())
				.clubCalendarPlace(calendarDTO.getClubCalendarPlace())
				.clubCalendarHeadCount(calendarDTO.getClubCalendarHeadCount())
				.clubCalendarPrice(calendarDTO.getClubCalendarPrice())
				.clubNum(ClubEntity.builder().clubNum(2L).build())
				.build();
		
		System.out.println(".... /calendarEntity interface dtoToEntity ....");
		return calendarEntity;
	}

}
