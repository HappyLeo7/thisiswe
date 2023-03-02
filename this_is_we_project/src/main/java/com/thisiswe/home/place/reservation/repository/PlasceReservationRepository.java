package com.thisiswe.home.place.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thisiswe.home.place.entity.PlaceReservationEntity;

public interface PlasceReservationRepository extends JpaRepository<PlaceReservationEntity, Long>{

//	@Query("selet")
//	List<PlaceReservationEntity> PlaceReservationList();
	
}
