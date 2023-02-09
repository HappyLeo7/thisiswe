package com.thisiswe.home.place.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thisiswe.home.user.entity.UserEntity;

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
@Table(name = "we_place_reservation")

//TODO [Entity]place_image 테이블 컬럼 (예약 번호, 장소 구역 번호, 예약자 명, 유저 ID, 예약 날짜, 예약 시간, 인원, 전화 번호)
public class PlaceReservationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_reservation_num")
	private Long placeReservationNum; // 예약 번호

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_zone_num")
	private PlaceZoneEntity plcaeZoneNum; // 장소 구역 번호
	
	@Column(length = 100, name = "place_reservation_name", nullable = false)
	private String place_reservation_name; // 예약자 명
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity userId; // 유저 ID

	@Column(length = 30, name = "place_reservation_date", nullable = false)
	private String placeReservationDate; // 예약 날짜
	
	@Column(length = 30, name = "place_reservation_time", nullable = false)
	private String placeReservationTime; // 예약 시간
	
	@Column(name = "place_reservation_headcount")
	private Long placeReservationHeadcount; // 인원
	
	@Column(length = 30, name = "place_reservation_tel", nullable = false)
	private String place_reservation_tel; // 전화 번호
}
