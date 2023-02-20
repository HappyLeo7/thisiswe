package com.thisiswe.home.club.calendar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.calendar.repository.CalendarRepository;
import com.thisiswe.home.club.dto.ClubDTO;
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

	//1개의 일정 데이터 가져오기
	@Override
	public CalendarDTO get(Long calendarNum) {
		log.info("..... calendar get() 1개 데이터 불러오기......");
		log.info("calendarNum : "+calendarNum );
		Optional<CalendarEntity> calendarEntity = calendarRepository.findById(calendarNum);
		log.info(calendarEntity.get());
		log.info("..... /calendar get() 1개 데이터 불러오기......");
		return entityToDTO(calendarEntity.get());
	}

	//일정 전체리스트 가져오기
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

	//일정 수정하기
	@Override
	public void modify(CalendarDTO calendarDTO, ClubDTO clubDTO) {
		log.info("........ 일정 modify() .........");
		log.info("받아온 모임 정보 : " + clubDTO);
		log.info("받아온 모임 일정 정보 : " + calendarDTO);
		
		List<Object[]> calendarEntity=calendarRepository.getClubCalendarNum(clubDTO.getClubNum(),calendarDTO.getClubCalendarNum());
		//List<CalendarDTO> entList =new ArrayList<>();
		log.info("일정 1개를 받아온 값   : "+calendarEntity);
		
		for(Object[] arr : calendarEntity) {
			log.info("모임정보 : "+ arr[0]);
			log.info("모임일정정보 : "+ arr[1]);
			
		}
		//if(arr[1] !=null) {
			//change
		//
		//}
		
		
		log.info("........ /일정 modify() .........");
		
		// TODO Auto-generated method stub
		
	}

	
	
	
}
