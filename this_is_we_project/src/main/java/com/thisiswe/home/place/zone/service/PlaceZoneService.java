package com.thisiswe.home.place.zone.service;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceZoneEntity;
import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;

public interface PlaceZoneService {

	void register(PlaceZoneDTO placeZoneDTO);

	//dto -> en
	default PlaceZoneEntity dtoToEntity(PlaceZoneDTO placeZoneDTO) {
		
		
		
		PlaceZoneEntity placeZoneEntity = PlaceZoneEntity.builder()
				.placeNum(PlaceEntity.builder().placeNum(placeZoneDTO.getPlaceNum()).build())
				.place_zone_name(placeZoneDTO.getPlace_zone_name())
				.build();
		
		System.out.println("장소zone : "+placeZoneEntity);
		
		return placeZoneEntity;
		
	}
}
