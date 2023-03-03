package com.thisiswe.home.place.zone.service;

import java.util.List;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;

public interface PlaceZoneService {

	void register(PlaceZoneDTO placeZoneDTO);
	
<<<<<<< HEAD
	List<PlaceZoneDTO> getPlaceZone(Long placeNum);
	
=======
>>>>>>> branch 'master(sub)' of https://github.com/HappyLeo7/thisiswe.git
	

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
<<<<<<< HEAD
	
	default PlaceZoneDTO entityToDTO(PlaceZoneEntity placeZoneEntity) {

		System.out.println("장소zone : "+placeZoneEntity);

		PlaceZoneDTO placeZoneDTO = PlaceZoneDTO.builder()
				.placeZoneNum(placeZoneEntity.getPlaceZoneNum())
				.placeNum(placeZoneEntity.getPlaceNum().getPlaceNum())
				.placeZoneName(placeZoneEntity.getPlaceZoneName())
				.placeZoneHeadCount(placeZoneEntity.getPlaceZoneHeadCount())
				.build();
		
		return placeZoneDTO;
		
	}
	
	
=======



	void get();
>>>>>>> branch 'master(sub)' of https://github.com/HappyLeo7/thisiswe.git
}
