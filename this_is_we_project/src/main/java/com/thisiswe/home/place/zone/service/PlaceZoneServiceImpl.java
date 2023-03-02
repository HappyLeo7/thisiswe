package com.thisiswe.home.place.zone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.repository.PlaceZoneRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PlaceZoneServiceImpl implements PlaceZoneService {

	@Autowired
	private PlaceZoneRepository placeZoneRepository;
	
	@Override
	public void register(PlaceZoneDTO placeZoneDTO) {
		log.info("... placeZone serivce register() ...");
		
		placeZoneRepository.save(dtoToEntity(placeZoneDTO));
		log.info("... /placeZone serivce register() ...");
		
	}

	
	
}
