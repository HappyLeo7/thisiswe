package com.thisiswe.home.club.calendar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.calendar.repository.CalendarRepository;
import com.thisiswe.home.club.entity.ClubEntity;

import org.springframework.stereotype.Service;

import com.thisiswe.home.club.calendar.dto.CalendarDTO;

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

	@Override
	public CalendarDTO get(Long calendarNum) {
		log.info("..... calendar get() 1개 데이터 불러오기......");
		log.info("calendarNum : "+calendarNum );
		Optional<CalendarEntity> calendarEntity = calendarRepository.findById(calendarNum);
		log.info(calendarEntity);
		log.info("..... /calendar get() 1개 데이터 불러오기......");
		return null;
	}

	@Override
	public List<CalendarDTO> getCalendarList(Long clubNum) {
		log.info("......getCalendarList()......");
		List<Object[]> list=calendarRepository.getClubNum(clubNum);
		List<CalendarDTO> entList= new ArrayList<>(); 
		log.info("......calendar list : "+list);
		for(Object[]arr : list) {
			log.info("배열 1"+arr[0]);
			log.info("배열 2"+arr[1]);
			entList.add(entityToDTO((CalendarEntity)arr[1]));
		}
		log.info("calendarEntity list 값 : "+entList);
		
		
		log.info("....../getCalendarList()......");
		
		
		return entList;
		
	}
	
	
	
}
