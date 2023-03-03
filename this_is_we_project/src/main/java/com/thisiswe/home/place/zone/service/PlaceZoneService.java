package com.thisiswe.home.place.zone.service;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;

public interface PlaceZoneService {

	void register(PlaceZoneDTO placeZoneDTO);

	//dto -> en
	default PlaceZoneEntity dtoToEntity(PlaceZoneDTO placeZoneDTO) {
		
		
		
		PlaceZoneEntity placeZoneEntity = PlaceZoneEntity.builder()
				.placeNum(PlaceEntity.builder().placeNum(placeZoneDTO.getPlaceNum()).build())
				.placeZoneName(placeZoneDTO.getPlaceZoneName())
				.placeZoneHeadCount(placeZoneDTO.getPlaceZoneHeadCount())
				 
				.build();
		
		System.out.println("장소zone : "+placeZoneEntity);
		
		return placeZoneEntity;
		
	}
}
