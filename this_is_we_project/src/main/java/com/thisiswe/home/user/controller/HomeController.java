package com.thisiswe.home.user.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thisiswe.home.user.entity.UserRoleEnum;
import com.thisiswe.home.user.security.UserDetailsImpl;


@Controller
public class HomeController {

	@Secured("ROLE_ADMIN")
	@GetMapping("/home")
	public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

		// addAttribute()와 같은 기능을 통해 모델에 원하는 속성과 그것에 대한 값을 주어 전달할 뷰에 데이터를 전달할 수 있습니다.
		model.addAttribute("username", userDetails.getUsername());

//		if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) 
//		if (userDetails.getUserRole().compareTo(UserRole.ADMIN)) {
		if (userDetails.getUserEntity().getRole() == UserRoleEnum.ADMIN){
			model.addAttribute("admin_role", true);
		}
		return "index";
	}
}
