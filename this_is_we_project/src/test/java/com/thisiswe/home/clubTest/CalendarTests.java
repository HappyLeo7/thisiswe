package com.thisiswe.home.clubTest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.calendar.repository.CalendarRepository;
import com.thisiswe.home.club.entity.ClubEntity;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class CalendarTests {

	
	@Autowired
	private CalendarRepository calendarRepository;
	
	//TODO [테스트] 일정 추가
	@Test
	public void calendarRegister() {
		IntStream.rangeClosed(21, 40).forEach(i->{
			
		CalendarEntity calendarEntity = CalendarEntity.builder()
				//.club_calendarHeadCount(null)
				.clubCalendarTitle("점심"+i)
				.clubCalendarContent("연어덮밥먹어요"+i)
				.clubCalendarTime("")
				.clubCalendarDate("2023-02-14")
				.clubCalendarTime("12:30:00")
				.clubCalendarPlace("강남역")
				.clubCalendarHeadCount(5L)
				.clubCalendarPrice(10000L)
				.clubNum(ClubEntity.builder().clubNum(1L).build())
				.build();
		
		calendarRepository.save(calendarEntity);
		
		});
		
		
	}
	
	@Test
	public void test() {
		
	}
	
	
}
