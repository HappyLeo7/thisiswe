package com.thisiswe.home.place.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceImageEntitiy;

public interface PlaceImageRepository extends JpaRepository<PlaceImageEntitiy, Long>{

	List<PlaceImageEntitiy> findByPlaceNum(PlaceEntity placeNum);
	
}
