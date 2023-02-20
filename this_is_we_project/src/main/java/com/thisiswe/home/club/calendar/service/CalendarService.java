package com.thisiswe.home.club.calendar.service;


import com.thisiswe.home.club.calendar.dto.CalendarDTO;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.dto.ClubDTO;


public interface CalendarService {
	
	
	//일정등록
	Long register(CalendarDTO calendarDTO);
	
	//1개의 일정 데이터를 불러온다.
	CalendarDTO get(Long calendarNum);
	
	Object getCalendarList(Long clubNum);
	
	//일정 수정매서드
	void modify(CalendarDTO calendarDTO, ClubDTO clubDTO);

	
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
	
	//entity -> dto
	default CalendarDTO entityToDTO(CalendarEntity calendarEntity) {
		System.out.println(".... calendarService entityToDTO() ....>>");
		
		CalendarDTO calendarDTO = CalendarDTO.builder()
				.clubCalendarNum(calendarEntity.getClubCalendarNum())
				.clubCalendarPlace(calendarEntity.getClubCalendarPlace())
				.clubCalendarTitle(calendarEntity.getClubCalendarTitle())
				.clubCalendarContent(calendarEntity.getClubCalendarContent())
				.clubCalendarDate(calendarEntity.getClubCalendarDate())
				.clubCalendarTime(calendarEntity.getClubCalendarTime())
				.clubCalendarPlace(calendarEntity.getClubCalendarPlace())
				.clubCalendarHeadCount(calendarEntity.getClubCalendarHeadCount())
				.clubCalendarPrice(calendarEntity.getClubCalendarPrice())
				.regDate(calendarEntity.getRegDate())
				.updateDate(calendarEntity.getUpdateDate())
				.build();
		
		System.out.println(".... /calendarService entityToDTO() ....");
		return calendarDTO;
	}

	

	
	

}
