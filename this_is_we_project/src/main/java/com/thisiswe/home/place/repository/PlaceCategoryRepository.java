package com.thisiswe.home.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.place.entity.PlaceCategoryEntity;

public interface PlaceCategoryRepository extends JpaRepository<PlaceCategoryEntity, Long>{
	
}
