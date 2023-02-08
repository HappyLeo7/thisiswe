package com.thisiswe.home.club.calendar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.enetity.DateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

//TODO [Entity]club_calendarEntity 테이블 컬럼(일정번호, 모임번호, 유저ID, 제목, 내용, 일정 날짜, 일정 시간, 장소, 인원, 비용, 등록일, 수정일)
public class CalendarEntity extends DateEntity{
	
	//TODO [Entity]PK거는 에노테이션 @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long club_calendar_num; //일정번호
	
	
	//TODO [Entity]FK거는 에노테이션 @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_num")
	private ClubEntity clubNum; //모임번호


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private ClubEntity userId; //유저ID
	
	
	@Column(length=100, name = "club_calendar_title")
	private String clubCalendarTitle; //제목
	
	@Column(length=1000, name = "club_calendar_content")
	private String clubCalendarContent; //내용
	
	@Column(length=30, name = "club_calendar_date")
	private String clubCalendarDate; //일정 날짜
	
	@Column(length=30, name = "club_calendar_time" )
	private String clubCalendarTime; //일정 시간
	
	@Column(length=100, name = "club_calendar_place")
	private String clubCalendarPlace; //장소
	
	@Column(name = "club_calendar_head_count")
	private Long club_calendarHeadCount; //인원
	
	@Column(name = "club_calendar_price")
	private Long clubCalendarPrice; //비용
	
	
	
}
