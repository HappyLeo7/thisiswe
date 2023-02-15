package com.thisiswe.home.place.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceReviewEntity;

public interface PlaceReviewRepository extends JpaRepository<PlaceReviewEntity, Long>{

	List<PlaceReviewEntity> findByPlaceNum(PlaceEntity placeNum);
}
