package com.thisiswe.home.place.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.place.reservation.dto.PlaceReservationDTO;
import com.thisiswe.home.place.reservation.service.PlasceReservationService;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/thisiswe/place")
@Log4j2
@RequiredArgsConstructor

public class ReservationController {
	
	@Autowired
	private PlasceReservationService plasceReservationService;

	//예약 페이지 연결
	@GetMapping({"/reservation"})
	public String reservation(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,Model model) {
		log.info("=== reservation() ===");
		
		model.addAttribute("userId",userDetailsImpl.getUsername());//접속중 유저 ID
		model.addAttribute("userNickname",userDetailsImpl.getUserNickname());//접속중 유저 닉네임
		
		log.info("=== /reservation() ===");
		
		return "reservation/reservation_register";
	}
	
	//예약 등록 처리
	@PostMapping({"/reservation"})
	public String reservationRegister(PlaceReservationDTO placeReservationDTO) {
		log.info("=== reservationRegister() ===");
		log.info("예약시 받아온 placeReservationDTO 값 : "+placeReservationDTO);
		
		plasceReservationService.register(placeReservationDTO);
		
		
		log.info("=== /reservationRegister() ===");
		return "redirect:/thisiswe/place/reservation";
	}
}
