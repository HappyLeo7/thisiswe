package com.thisiswe.home.place.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thisiswe.home.place.dto.PlaceReviewDTO;
import com.thisiswe.home.place.service.PlaceReviewService;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/place/review")
@RequiredArgsConstructor
@Log4j2
@RestController
public class PlaceReviewController {

	private final PlaceReviewService placeReviewService;

	@PostMapping("")
	public ResponseEntity<Long> registerReview(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @RequestBody PlaceReviewDTO placeReviewDTO) {
		log.info("============reviewRegister=============");
		// html jason 에서 유저 정보 않넣고 controller에서 세팅해줌 
		placeReviewDTO.setUserId(userDetailsImpl.getUsername());
		Long placeReviewNum = placeReviewService.register(placeReviewDTO);
		return new ResponseEntity<>(placeReviewNum, HttpStatus.OK);
		
	}

}
