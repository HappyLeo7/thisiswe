package com.thisiswe.home.place.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thisiswe.home.place.reservation.entity.PlaceReservationEntity;

public interface PlaceReservationRepository extends JpaRepository<PlaceReservationEntity, Long>{

	@Query("select p "
			+ "from PlaceReservationEntity p "
			+ "where placeReservationDate = :placeReservationDate")
	List<PlaceReservationEntity> dateToList(@Param("placeReservationDate") String placeReservationDate);
}
