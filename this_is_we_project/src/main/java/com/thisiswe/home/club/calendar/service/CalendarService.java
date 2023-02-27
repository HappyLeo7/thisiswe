package com.thisiswe.home.club.calendar.service;


import com.thisiswe.home.club.calendar.dto.CalendarDTO;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.dto.ClubDTO;


public interface CalendarService {
	
	
	//일정등록
	Long register(CalendarDTO calendarDTO);
	
	//1개의 일정 데이터를 불러온다.
	CalendarDTO get(Long calendarNum);
	
	//일정 리스트
	Object getCalendarList(Long clubNum);
	
	//일정 수정매서드
	CalendarDTO modify(CalendarDTO calendarDTO);

	
	//dto -> entity
	default CalendarEntity dtoToEntity(CalendarDTO calendarDTO) {
		System.out.println(".... calendarService interface dtoToEntity() ....");
		
		CalendarEntity calendarEntity = CalendarEntity.builder()
				.clubCalendarTitle(calendarDTO.getClubCalendarTitle())
				.clubCalendarContent(calendarDTO.getClubCalendarContent())
				.clubCalendarDate(calendarDTO.getClubCalendarDate())
				.clubCalendarTime(calendarDTO.getClubCalendarTimeH()+":"+calendarDTO.getClubCalendarTimeM())
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
				.clubNum(calendarEntity.getClubNum())
				.clubCalendarNum(calendarEntity.getClubCalendarNum())
				.clubCalendarPlace(calendarEntity.getClubCalendarPlace())
				.clubCalendarTitle(calendarEntity.getClubCalendarTitle())
				.clubCalendarContent(calendarEntity.getClubCalendarContent())
				.clubCalendarDate(calendarEntity.getClubCalendarDate())
				.clubCalendarTime(calendarEntity.getClubCalendarTime())
				.clubCalendarTimeH(calendarEntity.getClubCalendarTime().substring(0,2))
				.clubCalendarTimeM(calendarEntity.getClubCalendarTime().substring(3,5))
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
