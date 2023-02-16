package com.thisiswe.home.club.calendar.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.thisiswe.home.club.calendar.entity.CalendarEntity;

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

//TODO[Entity] calendar memeber 컬럼
public class CalendarMemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "club_calendar_member_num")
	private Long clubCalendarMemberNum; //구성원 번호
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private CalendarEntity userId; //유저ID

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "club_num")
	private CalendarEntity clubNum; //모임 번호

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "club_calendar_num")
	private CalendarEntity clubCalendarNum; //일정 번호
	
}
