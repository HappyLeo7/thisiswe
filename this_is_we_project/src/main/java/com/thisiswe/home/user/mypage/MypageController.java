package com.thisiswe.home.user.mypage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/thisiswe/mypage")
public class MypageController {
	
	private final MypageService mypageService;

	// 마이페이지 메인
	@GetMapping("/main")
	public String getMypageInfo() {
		return "mypage/main"; 
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
	@PutMapping("/{userId}")
	public ResponseEntity<String> modifyUserInfo(@PathVariable String userId, @RequestBody MypageDTO mypageDTO) {
		System.out.println("여기까지 들어오고 있는거니?");
		log.info("------------유저정보 수정----------");
		log.info("mypageDTO ; " + mypageDTO);
		
		mypageService.modifyUserInfo(mypageDTO);
		
		return new ResponseEntity<String>(userId, HttpStatus.OK);
	}
	
	
	// 마이페이지 게시판 읽어오기
	
	
//	@GetMapping("/board/user/list")
//	@ResponseBody
//	public Page<BoardDTO> getBoards(PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
//		userDetails.getUsername();
//		
//	return null;
//	}    
	
	// 마이페이지 게시판 읽어오기
	@GetMapping("/boardlist")
	public String myBoardList (PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
		log.info("=============== boardService.getList를 호출 ===============");
		model.addAttribute("result", mypageService.getList(pageRequestDTO, userDetails.getUsername()));		
		log.info("=========================================================");
	return "mypage/myboardlist";
	}    
}
