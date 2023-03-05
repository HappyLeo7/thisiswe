package com.thisiswe.home.place.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.place.dto.PlaceDTO;
import com.thisiswe.home.place.dto.PlacePageRequestDTO;
import com.thisiswe.home.place.service.PlaceService;
import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.dto.PlaceZoneTimePriceDTO;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;
import com.thisiswe.home.place.zone.entity.PlaceZoneTimePriceEntity;
import com.thisiswe.home.place.zone.repository.PlaceZoneTimePriceRepository;
import com.thisiswe.home.place.zone.service.PlaceZoneService;
import com.thisiswe.home.place.zone.service.PlaceZoneTimePriceService;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/thisiswe")
@RequiredArgsConstructor
@Log4j2
public class PlaceController {

	private final PlaceService placeService;
	private final PlaceZoneService placeZoneService;
	private final PlaceZoneTimePriceRepository placeZoneTimePriceRepository;
	private final PlaceZoneTimePriceService placeZoneTimePriceService;

	@GetMapping("place")
	public String list(PlacePageRequestDTO placePageRequestDTO, Model model) {
		log.info("================(get)placeListController==============");
		log.info(model.addAttribute("placeList", placeService.getList(placePageRequestDTO)));
		if (!placeService.getList(placePageRequestDTO).getDtoList().isEmpty()) {
			log.info("PlcaeThumbnailURL은" + placeService.getList(placePageRequestDTO).getDtoList().get(0).getPlaceImageDTOList()
					.get(0).getPlcaeThumbnailURL());
		}
		return "place/place_list";
	}

	@GetMapping("/place/c{num}")
	public String placeRead(Long num, Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl, PlaceZoneTimePriceEntity placeZoneTimePriceEntity) {
		log.info("================(get)placeReadController==============");
		model.addAttribute("loginID", userDetailsImpl.getUsername());
		model.addAttribute("place", placeService.getPlace(num));
		//model.addAttribute("zones", placeZoneService.getPlaceZone(num));
		
		//룸별 가격표 1개정보 보여주는 처리
		List<PlaceZoneDTO> placeZoneDTOs=placeZoneService.getPlaceZone(num);
		List<PlaceZoneDTO> list = new ArrayList<>();
		for(PlaceZoneDTO placeZoneDTO :placeZoneDTOs) {
		log.info(":받아오는값:"+placeZoneTimePriceService.placeZoneTimePriceList(placeZoneDTO));
		PlaceZoneTimePriceDTO zoneTimePriceread=placeZoneTimePriceService.placeZoneTimePriceList(placeZoneDTO);
		placeZoneDTO.setPlaceZoneTimePriceDTO(zoneTimePriceread);
		list.add(placeZoneDTO);
		}
		log.info("금액 뿌려줄 리스트 :"+list);
		model.addAttribute("zones",list);
		return "place/place_read";
	}

	// 장소 등록
	@GetMapping("/place/register")
	public String placeRegisterGet() {
		log.info("================(get)placeRegisterController==============");
		return "place/place_register";
	}

	// 장소 등록
	@PostMapping("/place/register")
	public String placeRegisterPost(PlaceDTO placeDTO, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		log.info("================(post)placeRegisterController==============");
		log.info(placeDTO);
		placeDTO.setUserId(userDetailsImpl.getUsername());
		placeService.register(placeDTO);
		return "redirect:/thisiswe/place";
	}
	
	
	// 장소 등록
	@GetMapping("/place/modify")
	public String placeModifyGet(Long placeNum, Model model) {
		log.info("================(get)placeModifyController==============");
		model.addAttribute("place",placeService.getPlace(placeNum));
		return "place/place_modify";
	}

	// 장소 등록
	@PostMapping("/place/modify")
	public String placeModifyPost(PlaceDTO placeDTO, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		log.info("================(post)placeModifyController==============");
		log.info(placeDTO);
		placeDTO.setUserId(userDetailsImpl.getUsername());
		placeService.register(placeDTO);
		return "redirect:/thisiswe/place";
	}
	
	// 장소 삭제
	@DeleteMapping("/place/remove/{placeNum}")
	public ResponseEntity<String> placeRemove(@PathVariable Long placeNum) {
		log.info("===========placeRemoveController============");
		log.info(placeNum);
		placeService.remove(placeNum);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
}
