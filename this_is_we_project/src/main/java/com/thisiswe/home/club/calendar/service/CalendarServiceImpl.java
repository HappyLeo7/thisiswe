package com.thisiswe.home.club.calendar.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.club.calendar.dto.CalendarDTO;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.calendar.repository.CalendarRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
	
	private final CalendarRepository calendarRepository;

	//일정등록 서비스
	@Override
	public Long register(CalendarDTO calendarDTO) {
		log.info("..... register() calendarDTO" + calendarDTO);
		CalendarEntity calendarEntity = dtoToEntity(calendarDTO);
		calendarRepository.save(calendarEntity);
		
		return calendarEntity.getClubCalendarNum();
	}
	
	
}
