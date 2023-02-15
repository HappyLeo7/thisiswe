package com.thisiswe.home.place.repository;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceImageEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceImageRepository extends JpaRepository<PlaceImageEntitiy, Long>{

	List<PlaceImageEntitiy> findByPlaceNum(PlaceEntity placeNum);
	
}
