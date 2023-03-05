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
public class PlaceZoneTimePriceDTO {
	
	/** 시간 별 금액 번호*/
	private Long placeZonePriceNum; // 시간 별 금액 번호

	/** 시간*/
	//private Long placeZonePriceTime; // 시간

	/** 금액*/
	private Long placeZonePriceTime01; // 금액
	private Long placeZonePriceTime02;
	private Long placeZonePriceTime03;
	private Long placeZonePriceTime04;
	private Long placeZonePriceTime05;
	private Long placeZonePriceTime06;
	private Long placeZonePriceTime07;
	private Long placeZonePriceTime08;
	private Long placeZonePriceTime09;
	private Long placeZonePriceTime10;
	private Long placeZonePriceTime11;
	private Long placeZonePriceTime12;
	private Long placeZonePriceTime13;
	private Long placeZonePriceTime14;
	private Long placeZonePriceTime15;
	private Long placeZonePriceTime16;
	private Long placeZonePriceTime17;
	private Long placeZonePriceTime18;
	private Long placeZonePriceTime19;
	private Long placeZonePriceTime20;
	private Long placeZonePriceTime21;
	private Long placeZonePriceTime22;
	private Long placeZonePriceTime23;
	private Long placeZonePriceTime24;
	
	/** 장소 구역 번호*/
	private PlaceZoneDTO placeZoneNum; // 장소 구역 번호
}
