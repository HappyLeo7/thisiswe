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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thisiswe.home.place.dto.PlaceReviewDTO;
import com.thisiswe.home.place.dto.PlaceReviewPageRequestDTO;
import com.thisiswe.home.place.dto.PlaceReviewPageResultDTO;
import com.thisiswe.home.place.entity.PlaceReviewEntity;
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
//	PlaceReviewPageRequestDTO placeReviewPageRequestDTO
//	value = "{placeNum}", produces = MediaType.APPLICATION_JSON_VALUE
	@GetMapping("{placeNum}")
	public ResponseEntity<PlaceReviewPageResultDTO<PlaceReviewDTO, PlaceReviewEntity>> getReviewByPlace(
			@RequestParam String placeNum,
			@RequestParam String page,
			@RequestParam String size,
			Model model) {
//		placeReviewPageRequestDTO.setPage(1);
//		placeReviewPageRequestDTO.setSize(10);
		log.info("============getReviewByPlace=============");
		model.addAttribute("page1", "1");
		log.info(" 몇번이게요 : "+model.addAttribute("page1"));
		
		log.info("플레이스 넘 : " + placeNum );
		log.info("page : " + page );
		log.info("size : " + size );
		return new ResponseEntity<>(placeReviewService.getList(new PlaceReviewPageRequestDTO(Integer.parseInt(page), Integer.parseInt(size), Long.parseLong(placeNum))), HttpStatus.OK);
	}
	//댓글 추가
	@PostMapping("")
	public ResponseEntity<Long> registerReview(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			@RequestBody PlaceReviewDTO placeReviewDTO) {
		log.info("============reviewRegister=============");

		// html json 에서 유저 정보 않넣고 controller에서 세팅해줌
		placeReviewDTO.setUserId(userDetailsImpl.getUsername());

		Long placeReviewNum = placeReviewService.register(placeReviewDTO);
		return new ResponseEntity<>(placeReviewNum, HttpStatus.OK);
	}
	
	//댓글 수정
	@PostMapping("/{placeReviewNum}")
	public ResponseEntity<Long> modifyReview(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			@RequestBody PlaceReviewDTO placeReviewDTO) {
		log.info("============reviewModify=============");
		placeReviewDTO.setUserId(userDetailsImpl.getUsername());

		Long placeReviewNum = placeReviewService.register(placeReviewDTO);
		return new ResponseEntity<>(placeReviewNum, HttpStatus.OK);
	}

	@DeleteMapping("/{placeReviewNum}")
	public ResponseEntity<String> removeReview(@PathVariable Long placeReviewNum) {
		log.info("============reviewRemover=============");

		placeReviewService.remove(placeReviewNum);
		return new ResponseEntity<>("success", HttpStatus.OK);

	}

}
