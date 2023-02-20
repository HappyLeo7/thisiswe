package com.thisiswe.home.club.calendar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thisiswe.home.club.calendar.entity.CalendarEntity;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Long>{

	
	//해당 모임의 일정들을 가져오는 쿼리문
	@Query("select c, ca "
			+ "from ClubEntity c "
			+ "left join CalendarEntity ca "
			+ "on c.clubNum = ca.clubNum "
			+ "where c.clubNum = :clubNum ")
	List<Object[]> getClubNum(@Param("clubNum") Long clubNum);
	
	
	//해당 모임의 일정 데이터 1개 불러오기
	@Query("select c,ca "
			+ "from CalendarEntity ca "
			+ "join ClubEntity c "
			+ "on c.clubNum = ca.clubNum "
			+ "where c.clubNum = :clubNum and ca.clubCalendarNum = :clubCalendarNum")
	List<Object[]> getClubCalendarNum(@Param("clubNum") Long clubNum,@Param("clubCalendarNum") Long calendarNum);
	
	/* 테스트용 일정 리스트 불러오기
	@Query(value="select * "
			+ "from calendar_entity ca "
			//+ "from calendar_entity ca "
			+ "left outer join club_entity c "
			+ "on c.club_num = ca.club_num "
			//+ "where ca.club_num ",
			+ "where ca.club_num = :num ",
			nativeQuery = true)
	List<CalendarEntity> gggg1(Long num);
	
	@Query("select c, ca "
			+ "from ClubEntity c "
			//+ "from calendar_entity ca "
			+ "right join CalendarEntity ca "
			+ "on c.clubNum = ca.clubNum "
			//+ "where ca.club_num ",
			+ "where ca.clubNum = 1"
			)
	List<Object[]> gggg();
	*/
}
