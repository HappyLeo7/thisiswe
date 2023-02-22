package com.thisiswe.home.place.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping(value = "/{placeNum}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PlaceReviewDTO>>getReviewByPlace (@PathVariable("placeNum")Long placeNum){
		log.info("============getReviewByPlace=============");
		return new ResponseEntity<>(placeReviewService.getList(placeNum),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Long> registerReview(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @RequestBody PlaceReviewDTO placeReviewDTO) {
		log.info("============reviewRegister=============");
		
		// html json 에서 유저 정보 않넣고 controller에서 세팅해줌
		placeReviewDTO.setUserId(userDetailsImpl.getUsername());
		
		Long placeReviewNum = placeReviewService.register(placeReviewDTO);
		return new ResponseEntity<>(placeReviewNum, HttpStatus.OK);
	}

	@PostMapping("/{placeReviewNum}")
	public ResponseEntity<Long> modifyReview(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @RequestBody PlaceReviewDTO placeReviewDTO) {
		log.info("============reviewModify=============");
		placeReviewDTO.setUserId(userDetailsImpl.getUsername());

		Long placeReviewNum = placeReviewService.register(placeReviewDTO);
		return new ResponseEntity<>(placeReviewNum, HttpStatus.OK);
	}
	
	@DeleteMapping("/{placeReviewNum}")
	public ResponseEntity<String>removeReview(@PathVariable Long placeReviewNum) {
		log.info("============reviewRemover=============");
		
		placeReviewService.remove(placeReviewNum);
		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}
	
}
