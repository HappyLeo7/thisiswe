package com.thisiswe.home.club.calendar.service;


import com.thisiswe.home.club.calendar.dto.CalendarDTO;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;


public interface CalendarService {
	
	
	//일정등록
	Long register(CalendarDTO calendarDTO);
	
	//1개의 일정 데이터를 불러온다.
	CalendarDTO get(Long calendarNum);
	
	
	//dto -> entity
	default CalendarEntity dtoToEntity(CalendarDTO calendarDTO) {
		System.out.println(".... calendarService interface dtoToEntity() ....");
		
		CalendarEntity calendarEntity = CalendarEntity.builder()
				.clubCalendarTitle(calendarDTO.getClubCalendarTitle())
				.clubCalendarContent(calendarDTO.getClubCalendarContent())
				.clubCalendarDate(calendarDTO.getClubCalendarDate())
				.clubCalendarTime(calendarDTO.getClubCalendarTime())
				.clubCalendarPlace(calendarDTO.getClubCalendarPlace())
				.clubCalendarHeadCount(calendarDTO.getClubCalendarHeadCount())
				.clubCalendarPrice(calendarDTO.getClubCalendarPrice())
				.clubNum(calendarDTO.getClubNum())
				.build();
		
		System.out.println(".... /calendarService interface dtoToEntity() ....");
		return calendarEntity;
	}

}
