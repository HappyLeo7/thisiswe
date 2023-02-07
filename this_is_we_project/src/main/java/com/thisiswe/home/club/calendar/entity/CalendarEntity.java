package com.thisiswe.home.club.calendar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.thisiswe.home.club.entity.DateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

//TODO [Entity]club_calendarEntity 테이블 컬럼(일정번호, 모임번호, 유저ID, 제목, 내용, 일정 날짜, 일정 시간, 장소, 인원, 비용, 등록일, 수정일)
public class CalendarEntity extends DateEntity{
	
	//TODO [Entity]PK거는 에노테이션 @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long club_calendar_num; //일정번호
	

	
	@Column(length=100)
	private String club_calendar_title; //제목
	
	@Column(length=1000)
	private String club_calendar_content; //내용
	
	@Column(length=30)
	private String club_calendar_date; //일정 날짜
	
	@Column(length=30)
	private String club_calendar_time; //일정 시간
	
	@Column(length=100)
	private String club_calendar_place; //장소
	
	@Column
	private Long club_calendar_head_count; //인원
	
	@Column
	private Long club_calendar_price; //비용
	
	
	
}
