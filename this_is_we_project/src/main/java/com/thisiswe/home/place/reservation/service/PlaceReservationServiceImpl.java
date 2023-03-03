package com.thisiswe.home.place.reservation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thisiswe.home.place.reservation.dto.PlaceReservationDTO;
import com.thisiswe.home.place.reservation.entity.PlaceReservationEntity;
import com.thisiswe.home.place.reservation.repository.PlaceReservationRepository;

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
		List<PlaceReservationEntity> list=placeReservationRepository.dateToList(placeReservationDTO.getPlaceReservationDate());
		log.info(list);
		List<PlaceReservationEntity> time= new ArrayList<>();
		for(PlaceReservationEntity arr : list ) {
			
		 String[] aa=arr.getPlaceReservationTime().split(",");
		 
			log.info("개별 값 : "+Arrays.toString(aa));
		}
		log.info("예약하고자하는 날짜의 사용 불가 시간 : "+time);
		log.info("... /Reservation getCheck() ...");
		return null;
	}
	
	

}
