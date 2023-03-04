package com.thisiswe.home.place.zone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;

public interface PlaceZoneRepository extends JpaRepository<PlaceZoneEntity, Long>{
	
	List<PlaceZoneEntity> findByPlaceNum(PlaceEntity placeNum);

}
