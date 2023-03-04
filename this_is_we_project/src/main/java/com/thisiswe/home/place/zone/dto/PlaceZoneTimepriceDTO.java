package com.thisiswe.home.place.zone.dto;


import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;

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
	private Long placeZoneTimepricePrice01; // 금액
	private Long placeZoneTimepricePrice02;
	private Long placeZoneTimepricePrice03;
	private Long placeZoneTimepricePrice04;
	private Long placeZoneTimepricePrice05;
	private Long placeZoneTimepricePrice06;
	private Long placeZoneTimepricePrice07;
	private Long placeZoneTimepricePrice08;
	private Long placeZoneTimepricePrice09;
	private Long placeZoneTimepricePrice10;
	private Long placeZoneTimepricePrice11;
	private Long placeZoneTimepricePrice12;
	private Long placeZoneTimepricePrice13;
	private Long placeZoneTimepricePrice14;
	private Long placeZoneTimepricePrice15;
	private Long placeZoneTimepricePrice16;
	private Long placeZoneTimepricePrice17;
	private Long placeZoneTimepricePrice18;
	private Long placeZoneTimepricePrice19;
	private Long placeZoneTimepricePrice20;
	private Long placeZoneTimepricePrice21;
	private Long placeZoneTimepricePrice22;
	private Long placeZoneTimepricePrice23;
	private Long placeZoneTimepricePrice24;
	
	/** 장소 구역 번호*/
	private PlaceZoneEntity placeZoneNum; // 장소 구역 번호
}
