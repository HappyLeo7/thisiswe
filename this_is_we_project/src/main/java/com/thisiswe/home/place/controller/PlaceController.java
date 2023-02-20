package com.thisiswe.home.place.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.place.dto.PlaceDTO;
import com.thisiswe.home.place.service.PlaceReviewService;
import com.thisiswe.home.place.service.PlaceService;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/thisiswe")
@RequiredArgsConstructor
@Log4j2
public class PlaceController {

	private final PlaceService placeService;
	private final PlaceReviewService placeReviewService;

	@GetMapping("place")
	public String List(Model model) {
		log.info("================(get)placeListController==============");
		model.addAttribute("placeList", placeService.getList());
		return "place/place_list";
	}

	@GetMapping("/place/c{num}")
	public String placeRead(Long num, Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		log.info("================(get)placeReadController==============");
		model.addAttribute("place", placeService.read(num));
		model.addAttribute("reviews", placeReviewService.getList(num));
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
		log.info("================(get)placeRegisterController==============");
		placeDTO.setUserId(userDetailsImpl.getUsername());
		placeService.register(placeDTO);
		return "redirect:/thisiswe/place";
	}
}
