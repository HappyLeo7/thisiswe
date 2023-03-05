package com.thisiswe.home.place.zone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;
import com.thisiswe.home.place.zone.repository.PlaceZoneRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PlaceZoneServiceImpl implements PlaceZoneService {

	@Autowired
	private PlaceZoneRepository placeZoneRepository;
	//등록처리
	@Override
	public void register(PlaceZoneDTO placeZoneDTO) {
		log.info("... placeZone serivce register() ...");
		
		placeZoneRepository.save(dtoToEntity(placeZoneDTO));
		log.info("... /placeZone serivce register() ...");
		
	}

	@Override
	public List<PlaceZoneDTO> getPlaceZone(Long placeNum) {
		log.info( "요청한 get place zone 정보 :"+placeZoneRepository.findByPlaceNum(PlaceEntity.builder().placeNum(placeNum).build()).stream().map(i-> entityToDTO(i)).toList());
		return placeZoneRepository.findByPlaceNum(PlaceEntity.builder().placeNum(placeNum).build()).stream().map(i-> entityToDTO(i)).toList();
	}
	
	//장소 넘버를 통해서 룸정보 1개 가져오기
	@Override
	public void get() {
		//placeZoneRepository.getToRead();
			
	}

	@Override
	public PlaceZoneDTO getPlaceZoneNum(String placeZoneName, Long placeNum) {
		
		log.info("... getPlaceZoneNum() 구하기위한 서비스 ...");
		
		PlaceZoneEntity num = PlaceZoneEntity.builder().placeNum(PlaceEntity.builder().placeNum(placeNum).build()).build();
		
		PlaceZoneEntity placeZoneEntity=placeZoneRepository.placeZoneNameToPlaceZoneNum(placeZoneName,num.getPlaceNum());
		log.info("룸이름으로 받아온 placeZoneEnetity 정보 : " +placeZoneEntity);
		
		log.info("... /getPlaceZoneNum() 구하기위한 서비스 ...");
		return entityToDTO(placeZoneEntity);
	}	
}