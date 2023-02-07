package com.thisiswe.home.club.calendar.member.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.entity.ClubEntity;

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
public class CalendarMemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long club_calendar_member_num; //구성원 번호
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CalendarEntity user_id; //유저ID

	@ManyToOne(fetch=FetchType.LAZY)
	private CalendarEntity club_num; //모임 번호

	@ManyToOne(fetch=FetchType.LAZY)
	private CalendarEntity club_calendar_num; //일정 번호
	
}
