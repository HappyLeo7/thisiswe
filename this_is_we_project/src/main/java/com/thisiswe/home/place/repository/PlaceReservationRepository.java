package com.thisiswe.home.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.place.entity.PlaceReservationEntity;

public interface PlaceReservationRepository extends JpaRepository<PlaceReservationEntity, Long>{

}