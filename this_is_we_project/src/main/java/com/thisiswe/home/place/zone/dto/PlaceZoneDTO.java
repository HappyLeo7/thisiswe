package com.thisiswe.home.place.zone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceZoneDTO {
	
	/** 장소 구역 번호*/
	private Long placeZoneNum; // 장소 구역 번호

	/** 장소 번호*/
	private Long placeNum; // 장소 번호

	/** 장소 구역 이름*/
	private String placeZoneName; // 장소 구역 이름
	
	/** 장소 구역 가용인원*/
	private Long placeZoneHeadCount;
	
	private PlaceZoneTimePriceDTO placeZoneTimePriceDTO;
	
}
