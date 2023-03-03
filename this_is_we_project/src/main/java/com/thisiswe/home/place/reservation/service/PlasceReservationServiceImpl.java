package com.thisiswe.home.place.reservation.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.place.repository.PlaceReservationRepository;
import com.thisiswe.home.place.reservation.dto.PlaceReservationDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlasceReservationServiceImpl implements PlasceReservationService {
	
	private final PlaceReservationRepository placeReservationRepository;

	@Override
	public void register(PlaceReservationDTO placeReservationDTO) {
		log.info("... Reservation register() ...");
		
		
		placeReservationRepository.save(dtoToEntity(placeReservationDTO));
		
		log.info("... /Reservation register() ...");
	}
	
	

}
