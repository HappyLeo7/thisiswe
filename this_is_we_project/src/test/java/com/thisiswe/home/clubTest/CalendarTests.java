package com.thisiswe.home.clubTest;

import java.util.Arrays;
import java.util.List;
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
				.clubNum(ClubEntity.builder().clubNum(3L).build())
				.build();
		
		calendarRepository.save(calendarEntity);
		
		});
		
		
	}
	
	@Test
	public void testCalendarList() {
		
		Long clubNum=195L;
		List<Object[]> cal=calendarRepository.getClubNum(clubNum);
		for (Object[] arr:cal) {
			log.info("일정 리스트 : " +Arrays.toString(arr));
			log.info("모임정보 : "+arr[0]);
			log.info("일정정보 : "+arr[1]);
		}
		
		
		
	}
	
	@Test
	public void testCalendarAllList() {
//		System.out.println("111111111111111111");
		
		//List<CalendarEntity> cal=calendarRepository.gggg1(1L);
		//System.out.println("22222222222222");
		//System.out.println(cal.toString());
//		for (CalendarEntity arr : cal) {
////			System.out.println("33333333333");
//			log.info("일정 리스트 : " +arr);
			
		}
	
	
}
