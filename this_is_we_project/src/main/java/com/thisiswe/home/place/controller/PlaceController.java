package com.thisiswe.home.place.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.place.service.PlaceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/place")
@RequiredArgsConstructor
@Log4j2
public class PlaceController {

	private final PlaceService placeService;
	
	@GetMapping("/placelist")
	public String List(Model model) {
		log.info("================placeListController==============");
		model.addAttribute("result", placeService.getList());
		return "place/place_list";
	}
	
	@GetMapping("/place{placeNum}")
	public String placeRead(Long placeNum, Model model) {
		log.info("================placeReadController==============");
		model.addAttribute("result", placeService.read(placeNum));
		return "place/place_read";
	}
	
}
