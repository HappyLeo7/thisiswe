package com.thisiswe.home.place.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/thisiswe/place")
@Log4j2
@RequiredArgsConstructor

public class reservationController {

	@GetMapping({"/reservation"})
	public String reservationRegister() {
		
		
		return "/reservation/reservation_register";
	}
}
