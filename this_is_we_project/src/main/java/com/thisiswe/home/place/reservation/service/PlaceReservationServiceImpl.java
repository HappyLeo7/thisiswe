package com.thisiswe.home.place.reservation.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.place.repository.PlaceReservationRepository;
import com.thisiswe.home.place.reservation.dto.PlaceReservationDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaceReservationServiceImpl implements PlaceReservationService {
	
	private final PlaceReservationRepository placeReservationRepository;

	@Override
	public void register(PlaceReservationDTO placeReservationDTO) {
		log.info("... Reservation register() ...");
		
		
		placeReservationRepository.save(dtoToEntity(placeReservationDTO));
		
		log.info("... /Reservation register() ...");
	}

	@Override
	public Boolean getCheck(PlaceReservationDTO placeReservationDTO) {
		log.info("... Reservation getCheck() ...");
		
		//날짜를 이용해서 시간 가져오기
		
		
		
		log.info("... /Reservation getCheck() ...");
		return null;
	}
	
	

}
