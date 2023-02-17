package com.thisiswe.home.user.mypage;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MypageController {
	private final MypageService mypageService;

	// 회원정보 조회
	@GetMapping("/user/read")
	public String getUserInfo(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		mypageService.getUserInfo(userDetails.getUsername());
		
		
//		model.addAttribute("username");
		return null;
	}

	// 자기가 쓴 게시글
	@GetMapping("/user/board")
	public String getUserBoards(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		mypageService.getUserBoards(userDetails.getUsername());
		return null;
	}

	// 지가 가입한 모임
	@GetMapping("/user/club")
	public String getUserClubs(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		mypageService.getUserClubs(userDetails.getUsername());
		return null;
	}

	// 회원정보 수정
	@PostMapping("/user/modify")
	public String updateUserInfo(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		mypageService.updateUserInfo(userDetails.getUsername());
		return null;
	}
	
}
