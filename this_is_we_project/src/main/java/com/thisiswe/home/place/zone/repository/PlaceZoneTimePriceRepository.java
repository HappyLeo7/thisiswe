package com.thisiswe.home.place.zone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;
import com.thisiswe.home.place.zone.entity.PlaceZoneTimePriceEntity;

public interface PlaceZoneTimePriceRepository extends JpaRepository<PlaceZoneTimePriceEntity, Long>{

	//Object placeZoneTimePriceList();
	 List<PlaceZoneTimePriceEntity> findByPlaceZoneNum(PlaceZoneEntity placeZoneNum);
}
