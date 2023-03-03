package com.thisiswe.home.place.zone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.service.PlaceZoneService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/thisiswe/place/zone")
@Controller
@RequiredArgsConstructor
@Log4j2
public class PlaceZoneController {
	
	private final PlaceZoneService placeZoneService;

	//장소 zone 등록 페이지 연결
	@GetMapping({"/register"})
	public String zone() {
		log.info("=== zone() ===");
		
		
		log.info("=== /zone() ===");
		return "place/place_zone_register";
		
	}
	
	@PostMapping({"/register"})
	public String zoneRegister(PlaceZoneDTO placeZoneDTO) {
		log.info("=== zoneRegister() ===");
		log.info("placeZoneDTO : "+placeZoneDTO);
		placeZoneService.register(placeZoneDTO);
		
		log.info("=== /zoneRegister() ===");
		
		return "place/place_zone_register";
	}
}
