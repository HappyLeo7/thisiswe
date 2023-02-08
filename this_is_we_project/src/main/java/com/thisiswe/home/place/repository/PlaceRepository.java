package com.thisiswe.home.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.place.entity.PlaceEntity;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {

}
