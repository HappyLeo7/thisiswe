package com.thisiswe.home.place.zone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.dto.PlaceZoneTimePriceDTO;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;
import com.thisiswe.home.place.zone.entity.PlaceZoneTimePriceEntity;
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

	@Override
	public PlaceZoneTimePriceDTO placeZoneTimePriceList(PlaceZoneDTO placeZoneDTO) {
		log.info("... placeZoneTimePriceList ...");
		log.info("... 요청한 zone num : " + placeZoneDTO.getPlaceZoneNum());
		List<PlaceZoneTimePriceEntity> pl=placeZoneTimePriceRepository.findByPlaceZoneNum(PlaceZoneEntity.builder().placeZoneNum(placeZoneDTO.getPlaceZoneNum()).build());
		log.info("... placeZoneTimePriceEntity 요청list : "+pl);
		log.info("... placeZoneTimePriceEntity 요청get(0) : "+pl.get(0));
		log.info("... /placeZoneTimePriceList ...");
		return entityToDto(pl.get(0));
		//return null;
	}

	
}