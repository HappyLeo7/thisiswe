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
	
	@Query("select pr "
			+ " from PlaceZoneEntity pz "
			+ " join PlaceReservationEntity pr "
		    + " on pz.placeZoneNum = pr.placeZoneNum "
			+ " where pz.placeZoneNum = :placeZoneNum "
			+ " order by pr.placeReservationDate asc ")
	List<PlaceReservationEntity> getPlaceNumToZoneNumToReservationList(@Param("placeZoneNum") Long placeZoneNum); 
}
