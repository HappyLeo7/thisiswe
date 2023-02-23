package com.thisiswe.home.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thisiswe.home.user.dto.SignupRequestDto;
import com.thisiswe.home.user.security.UserDetailsImpl;
import com.thisiswe.home.user.service.KakaoUserService;
import com.thisiswe.home.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/thisiswe")
@RequiredArgsConstructor // final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 만듦
public class UserController {

	private final UserService userService;
	private final KakaoUserService kakaoUserService;

	// 회원 로그인 페이지
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	// post login 이동
	@PostMapping("/login")
	public String loginsucces() {
		return "login/login";
	}

	// 회원 가입 페이지
	@GetMapping("/signup")
	public String signup() {
		return "login/signup";
	}

	// 회원 가입 요청 처리
	@PostMapping("/signup")
	public String registerUser(SignupRequestDto requestDto) {
		
		System.out.println("확인용");
		userService.registerUser(requestDto);
		return "/login/login";
	}

//	@GetMapping("/user/kakao/callback")
	@GetMapping("/login/oauth2/code/kakao")
	public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
		kakaoUserService.kakaoLogin(code);
		return "redirect:/";
	}
	

	// 회원정보 조회
	@GetMapping("/userinfo")
	public String getUserInfo(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		// 첫번째 방법
		
		model.addAttribute("userId", userDetails.getUserEntity().getUserId());
		model.addAttribute("userNickname", userDetails.getUserEntity().getUserNickname());
		model.addAttribute("userEmail", userDetails.getUserEntity().getUserEmail());

		return "mypage/userinfo";
	}
	
	// 유저아이디 조회
	@PostMapping("/{userid}")
	@ResponseBody
	public ResponseEntity<Boolean> checkUserId(@PathVariable("userid") String userid) {
		
		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userid);
		
		return new ResponseEntity<>(userService.checkUserId(userid) ,HttpStatus.OK);
	}
	
	// 유저닉네임 조회
	@PostMapping("/nickname/{userNickname}")
	@ResponseBody
	public ResponseEntity<Boolean> checkUserNickname(@PathVariable("userNickname") String userNickname) {
		
		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userNickname);
		
		return new ResponseEntity<>(userService.checkUserNickname(userNickname) ,HttpStatus.OK);
	}
	
	// 유저인증코드 보내기
	@PostMapping("/userEmail/{emailCheck}")
	@ResponseBody
	public void pushUserEmailCode(@PathVariable("emailCheck") String userEmail) {
		
		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userEmail);

		userService.sendVerificationCode(userEmail);
	}
	
	// 이메일 인증코드 확인
	@PostMapping("/userEmail/{emailCheck}/{emailCodeCheck}")
	@ResponseBody
	public ResponseEntity<Boolean> checkUserEmail(@PathVariable("emailCheck") String userEmail, @PathVariable("emailCodeCheck") String userEmialCode) {
		
		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userEmail);
		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userEmialCode);
		
		return new ResponseEntity<>(userService.verifyCode(userEmail, userEmialCode), HttpStatus.OK);
	}
}