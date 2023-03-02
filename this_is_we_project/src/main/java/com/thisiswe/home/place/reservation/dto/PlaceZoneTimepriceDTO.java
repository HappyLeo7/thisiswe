package com.thisiswe.home.place.reservation.dto;


import com.thisiswe.home.place.entity.PlaceZoneEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceZoneTimepriceDTO {
	
	/** 시간 별 금액 번호*/
	private Long wePlaceZonePriceNum; // 시간 별 금액 번호

	/** 시간*/
	private Long placeZonePriceTime; // 시간

	/** 금액*/
	private Long placeZoneTimepricePrice; // 금액
	
	/** 장소 구역 번호*/
	private PlaceZoneEntity placeZoneNum; // 장소 구역 번호
}
