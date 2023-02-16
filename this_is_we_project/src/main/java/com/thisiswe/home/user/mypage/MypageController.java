package com.thisiswe.home.user.mypage;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/thisiswe/mypage")
public class MypageController {
	private final MypageService mypageService;

	// 마이페이지 메인
	@GetMapping("/main")
	public String getMypageInfo() {
		return "mypage/main"; 
	}
		
	// 회원정보 조회
	@GetMapping("/userinfo")
	public String getUserInfo(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		// 첫번째 방법
		
//		System.out.println(authentication.getPrincipal());
		
		model.addAttribute("userNickname", userDetails.getUserEntity().getUserNickname());
		model.addAttribute("userEmail", userDetails.getUserEntity().getUserEmail());
//		model.addAttribute("userImageUrl", userDetails.getUserEntity().getUserImageUrl());
		
//		model.addAttribute("username");
		return "mypage/userinfo";
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
	@PostMapping("/userinfomodify")
	public String updateUserInfo(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		mypageService.updateUserInfo(userDetails.getUsername());
		return null;
	}
	
}
