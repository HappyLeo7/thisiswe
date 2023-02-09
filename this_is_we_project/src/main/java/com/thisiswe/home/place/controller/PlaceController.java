package com.thisiswe.home.place.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.place.service.PlaceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {

	private final PlaceService placeService;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("result", placeService.getList());
	}
	
}
