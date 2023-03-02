package com.thisiswe.home.place.reservation.dto;


import com.thisiswe.home.place.entity.PlaceZoneEntity;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceReservationDTO {
	
	/** 예약 번호 */
	private Long placeReservationNum; // 예약 번호

	/** 장소 구역 번호 */
	private PlaceZoneEntity placeZoneNum; // 장소 구역 번호
	
	/** 예약자 명 */
	private String place_reservation_name; // 예약자 명
	
	/** 유저 ID */
	private UserEntity userId; // 유저 ID

	/** 예약 날짜 */
	private String placeReservationDate; // 예약 날짜
	
	/** 예약 시간 */
	private String placeReservationTime; // 예약 시간
	private String placeReservationTimeStart; // 예약 시간
	private String placeReservationTimeEnd; // 예약 시간
	
	/** 인원 */
	private Long placeReservationHeadcount; // 인원
	
	/** 전화 번호 */
	private String place_reservation_tel; // 전화 번호
}
