package com.thisiswe.home.place.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceReviewEntity;

public interface PlaceReviewRepository extends JpaRepository<PlaceReviewEntity, Long>{

	Page<PlaceReviewEntity> findByPlaceNum(PlaceEntity placeNum, Pageable pageable);
	
}
 