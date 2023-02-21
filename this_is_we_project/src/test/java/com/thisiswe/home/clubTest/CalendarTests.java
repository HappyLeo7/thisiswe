package com.thisiswe.home.clubTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.club.calendar.dto.CalendarDTO;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.calendar.repository.CalendarRepository;
import com.thisiswe.home.club.calendar.service.CalendarService;
import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class CalendarTests {

	
	@Autowired
	private CalendarRepository calendarRepository;
	
	@Autowired
	private CalendarService calendarService;
	
	//TODO [테스트] 일정 추가
	@Test
	public void calendarRegister() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			
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
	
	//calendarAllList 캘린더 전체 일정 가져오는 테스트
	@Test
	public void testCalendarList() {
		
		Long clubNum=3L;
		List<Object[]> cal=calendarRepository.getClubNum(clubNum);
		for (Object[] arr:cal) {
			log.info("일정 리스트 : " +Arrays.toString(arr));
			log.info("모임정보 : "+arr[0]);
			log.info("일정정보 : "+arr[1]);
		}
		
		
		
	}
	
	//일정수정테스트
	@Test
	public void testCalendarModfiy() {
			
		System.out.println("");
		System.out.println("'''''일정수정 테스트''''''");
			CalendarDTO calendarDTO = CalendarDTO.builder()
					.clubCalendarNum(1L)
					.clubCalendarTitle("점심수정")
					.clubCalendarContent("연어덮밥 수정")
					.clubCalendarDate("2025-01-01")
					.clubCalendarTime("13:50:00")
					.clubCalendarPlace("수정역")
					.clubCalendarHeadCount(10L)
					.clubCalendarPrice(20000L)
					.build();
			
			ClubDTO clubDTO=ClubDTO.builder()
					.clubNum(3L).build();
			
			System.out.println("일정 수정값 : "+calendarDTO);
			
			System.out.println("");
			
			calendarService.modify(calendarDTO, clubDTO);
			
			System.out.println("'''''/일정수정 테스트''''''");
			System.out.println("");
	}
	
	
}
