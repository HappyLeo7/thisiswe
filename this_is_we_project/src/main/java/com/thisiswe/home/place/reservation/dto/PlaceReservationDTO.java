package com.thisiswe.home.place.reservation.dto;


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
	/** 장소 번호 */
	private Long placeNum; // 장소 구역 번호

	/** 장소 구역 번호 */
	private Long placeZoneNum; // 장소 구역 번호
	/** 장소 구역 이름 */
	private String placeZoneName; // 장소 구역 이름
	
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
	
	/** 카드 번호1 */
	private Long placeReservationCardNumber1;
	/** 카드 번호2 */
	private Long placeReservationCardNumber2;
	/** 카드 번호3 */
	private Long placeReservationCardNumber3;
	/** 카드 번호4 */
	private Long placeReservationCardNumber4;
	/** 카드 유효날짜 년도 */
	private Long placeReservationCardYear;
	/** 카드 유효날짜 월 */
	private Long placeReservationCardMonth;
	/** 카드 사용자 이름 */
	private String placeReservationCardUserName;	
	/** 카드 비밀번호 앞자리2개 */
	private Long placeReservationCardpassword;	
	

}
