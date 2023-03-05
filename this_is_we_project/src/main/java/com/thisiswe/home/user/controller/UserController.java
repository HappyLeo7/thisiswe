package com.thisiswe.home.user.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/thisiswe")
@Log4j2
@RequiredArgsConstructor // final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 만듦
public class UserController {

	private final UserService userService;
	private final KakaoUserService kakaoUserService;


	// 회원 로그인 페이지
	@GetMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	    Cookie[] cookies = request.getCookies();
	    log.info("확인");
	    System.out.println("쿠키 확인 : " + (cookies != null));
	    System.out.println("userDetail 세션확인 : "+ (session.getAttribute("userDetails") != null));
	    if (cookies != null && session.getAttribute("userDetails") != null) {
	        for (Cookie cookie : cookies) {
	            System.out.println("세션이 만료되었는지 확인 : " + (session.getAttribute("userDetails")));
	            if (cookie.getName().equals("loggedIn") && cookie.getValue().equals("true")) {
	                return "redirect:/thisiswe";
	            }
	        }
	    }
	    String referrer = request.getHeader("Referer");
	    session.setAttribute("previousPage", referrer);
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "0");
	    return "login/login";
	}

	
	@GetMapping("/loginCheck")
	public String loginsucces(HttpServletRequest request, HttpServletResponse response, @AuthenticationPrincipal UserDetailsImpl userDetails, HttpSession session) throws IOException {
		
		session.setAttribute("userDetails", userDetails);
		System.out.println("세션이 저장되는지 확인" + (session.getAttribute("userDetails") != null));

	    System.out.println(session);
	    String previousPage = (String) session.getAttribute("previousPage");
	    if (previousPage != null) {
	        session.removeAttribute("previousPage");
	        return "redirect:" + previousPage;
	    } else {
	    	return "redirect:/thisiswe";
	    }
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

	// 카카오 로그인
	@GetMapping("/login/oauth2/code/kakao")
	public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
		kakaoUserService.kakaoLogin(code);
		return "redirect:/thisiswe";
	}

	// 회원정보 조회
	@GetMapping("/userinfo")
	public String getUserInfo(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		// 첫번째 방법

		model.addAttribute("userId", userDetails.getUsername());
		model.addAttribute("userNickname", userDetails.getUserEntity().getUserNickname());
		model.addAttribute("userEmail", userDetails.getUserEntity().getUserEmail());

		return "mypage/userinfo";
	}

	// 유저아이디 조회
	@PostMapping("/{userid}")
	@ResponseBody
	public ResponseEntity<Boolean> checkUserId(@PathVariable("userid") String userid) {

		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userid);

		return new ResponseEntity<>(userService.checkUserId(userid), HttpStatus.OK);
	}

	// 유저닉네임 조회
	@PostMapping("/nickname/{userNickname}")
	@ResponseBody
	public ResponseEntity<Boolean> checkUserNickname(@PathVariable("userNickname") String userNickname) {

		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userNickname);

		return new ResponseEntity<>(userService.checkUserNickname(userNickname), HttpStatus.OK);
	}

	// 유저 비밀번호 조회 일치 여부확인 후 탈퇴
	@PostMapping("/user/check/{password}")
	@ResponseBody
	public ResponseEntity<String> checkUserPassword(@PathVariable("password") String password,
			@AuthenticationPrincipal UserDetailsImpl userDetails, HttpSession session) {

		if (userService.checkUserPassword(userDetails.getUsername(), password)) {
			userService.deleteUser(userDetails.getUsername());
			session.removeAttribute("userDetails");
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("fail", HttpStatus.OK);
		}
	}

	// 유저인증코드 보내기
	@PostMapping("/userEmail/{emailCheck}")
	@ResponseBody
	public String pushUserEmailCode(@PathVariable("emailCheck") String userEmail) {

		if (userService.checkUserEmail(userEmail)) {
			return "중복";
		} else {
			System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userEmail);

			userService.sendVerificationCode(userEmail);

			return "메일 보냄";
		}
	}

	// 이메일 인증코드 확인
	@PostMapping("/userEmail/{emailCheck}/{emailCodeCheck}")
	@ResponseBody
	public ResponseEntity<Boolean> checkUserEmail(@PathVariable("emailCheck") String userEmail,
			@PathVariable("emailCodeCheck") String userEmialCode) {

		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userEmail);
		System.out.println("$%$#%$#%$#%$#%$#%$#%$#%$%$#%	" + userEmialCode);

		return new ResponseEntity<>(userService.verifyCode(userEmail, userEmialCode), HttpStatus.OK);
	}
}