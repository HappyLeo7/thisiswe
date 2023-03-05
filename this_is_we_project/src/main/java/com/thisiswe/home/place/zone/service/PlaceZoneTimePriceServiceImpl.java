package com.thisiswe.home.place.zone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisiswe.home.place.zone.dto.PlaceZoneTimePriceDTO;
import com.thisiswe.home.place.zone.repository.PlaceZoneTimePriceRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PlaceZoneTimePriceServiceImpl implements PlaceZoneTimePriceService {
	
	@Autowired
	private PlaceZoneTimePriceRepository placeZoneTimePriceRepository;
	
	@Override
	public void register(PlaceZoneTimePriceDTO placeZoneTimePriceDTO) {
		log.info("... placeZoneTimePrice register 처리 ...");
		
		placeZoneTimePriceRepository.save(dtoToEntity(placeZoneTimePriceDTO));
		log.info("... /placeZoneTimePrice register 처리 ...");
	}

	
}