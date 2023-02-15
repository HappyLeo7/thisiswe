package com.thisiswe.home.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thisiswe.home.user.dto.SignupRequestDto;
import com.thisiswe.home.user.service.KakaoUserService;
import com.thisiswe.home.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 만듦
public class UserController {

	private final UserService userService;
	private final KakaoUserService kakaoUserService;

	// 회원 로그인 페이지
	@GetMapping("/login/user/login")
	public String login() {
		return "/login/login";
	}

	// 회원 가입 페이지
	@GetMapping("/user/signup")
	public String signup() {
		return "signup";
	}

	// 회원 가입 요청 처리
	@PostMapping("/user/signup")
	public String registerUser(SignupRequestDto requestDto) {
		userService.registerUser(requestDto);
		return "redirect:/user/login";
	}

//	@GetMapping("/user/kakao/callback")
	@GetMapping("/login/oauth2/code/kakao")
	public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
		kakaoUserService.kakaoLogin(code);
		return "redirect:/";
	}
	
	@GetMapping("/test/check")
	public String check() {
		return "onlyAdmin";
	}
}