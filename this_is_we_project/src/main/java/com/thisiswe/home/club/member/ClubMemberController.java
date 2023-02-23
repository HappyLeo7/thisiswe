package com.thisiswe.home.club.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/thisiswe/club")
@Controller
@RequiredArgsConstructor
@Log4j2
public class ClubMemberController {

	private final ClubMemberService clubMemberService;
	
	
	@PostMapping("/member")
	public ResponseEntity<Long> clubMemberber_register(@RequestBody ClubMemberDTO clubMemberDTO) {
		
		log.info("==== post club member register() ====");
		log.info(clubMemberDTO);
		
		clubMemberService.clubMemberRegister(clubMemberDTO);
		
		log.info("==== /post club member register() ====");
		return new ResponseEntity<Long>(clubMemberDTO.getClubNum(), HttpStatus.OK);
	}
}
