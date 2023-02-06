package com.thisiswe.home.club.calendar.member.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

//TODO[Entity] calendar memeber 컬럼
public class CalendarMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long club_calendar_member_num; //구성원 번호
	
	@ManyToOne(fetch = FetchType.LAZY)
	private String user_id; //유저ID
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Long club_num; //모임 번호
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Long club_calendar_num; //일정 번호
}
