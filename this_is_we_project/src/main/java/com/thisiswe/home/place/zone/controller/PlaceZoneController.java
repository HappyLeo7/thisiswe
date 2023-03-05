package com.thisiswe.home.place.zone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.place.reservation.dto.PlaceReservationDTO;
import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.dto.PlaceZoneTimePriceDTO;
import com.thisiswe.home.place.zone.service.PlaceZoneService;
import com.thisiswe.home.place.zone.service.PlaceZoneTimePriceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/thisiswe/place/zone")
@Controller
@RequiredArgsConstructor
@Log4j2
public class PlaceZoneController {
	
	private final PlaceZoneService placeZoneService;
	private final PlaceZoneTimePriceService placeZoneTimePriceService;

	//장소 zone 등록 페이지 연결
	@GetMapping({"/register"})
	public String zone(Long placeNum, Model model) {
		log.info("=== zone() ===");
		
		log.info("placeNum : "+placeNum);
	
		model.addAttribute("placeNum", placeNum);
		
		log.info("=== /zone() ===");
		return "place/place_zone_register";
		
	}
	//zone 등록 처리
	@PostMapping({"/register"})
	public String zoneRegister(PlaceZoneDTO placeZoneDTO, PlaceZoneTimePriceDTO placeZoneTimepriceDTO) {
		log.info("=== zoneRegister() ===");
		log.info("placeZoneDTO : "+placeZoneDTO);
		placeZoneService.register(placeZoneDTO); //룸정보 등록처리
		
		//룸이름으로 룸번호 불러오기
		PlaceZoneDTO placeZone=placeZoneService.getPlaceZoneNum(placeZoneDTO.getPlaceZoneName(),placeZoneDTO.getPlaceNum());
		placeZoneTimepriceDTO.setPlaceZoneNum(PlaceZoneDTO.builder().placeZoneNum(placeZone.getPlaceNum()).build());
		log.info("placeZoneTimepriceDTO : "+placeZoneTimepriceDTO);
		//시간별 금액 테이블에 저장
		placeZoneTimePriceService.register(placeZoneTimepriceDTO);
		
		log.info("=== /zoneRegister() ===");
		
		return "redirect:/thisiswe/place/c?num="+placeZoneDTO.getPlaceNum();
	}
	
	//zone 상세 페이지 연결
	@GetMapping({"/read"})
	public String readPage(PlaceZoneDTO placeZoneDTO) {
		log.info("=== readPage() ===");
		log.info(placeZoneDTO);
		//placeZoneService.get(placeZoneDTO);
		
		log.info("=== /readPage() ===");
		return "place/place_zone_read";
	}
}
