package com.thisiswe.home.place.zone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;

public interface PlaceZoneRepository extends JpaRepository<PlaceZoneEntity, Long>{
	
	List<PlaceZoneEntity> findByPlaceNum(PlaceEntity placeNum);

	@Query("select pz "
			+ " from PlaceZoneEntity pz "
			+ " where pz.placeNum = :placeNum and pz.placeZoneName = :placeZoneName ")
	PlaceZoneEntity placeZoneNameToPlaceZoneNum(@Param("placeZoneName") String placeZoneName,@Param("placeNum") PlaceEntity placeNum);
	}
