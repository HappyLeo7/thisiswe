package com.thisiswe.home.place;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.place.reservation.entity.PlaceReservationEntity;
import com.thisiswe.home.place.reservation.repository.PlaceReservationRepository;

@SpringBootTest
public class PlaceReservationTests {
	
	@Autowired
	private PlaceReservationRepository placeReservationRepository;

	@Test
	public void reservationList() {
		System.out.println("테스트중");
		List<PlaceReservationEntity> list=
		placeReservationRepository.getPlaceNumToZoneNumToReservationList(1L);
		
		for(PlaceReservationEntity arr : list) {
			System.out.println(arr.getPlaceZoneNum().getPlaceZoneNum());
		}
		
		System.out.println("/테스트중");
		
		
	}
}
