package com.thisiswe.home.user.mypage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.repository.BoardRepository;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/thisiswe/mypage")
public class MypageController {
	
	private final MypageService mypageService;
	private final BoardRepository boardRepository;

	// 마이페이지 메인
	@GetMapping("/main")
	public String getMypageMain() {
		return "mypage/main"; 
	}
	
	// 유저 회원정보
	@GetMapping("/userinfo")
	public String getMypageInfo(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		model.addAttribute("userId", userDetails.getUsername());
		return "mypage/userinfo";
	}

	// 회원정보 수정
	@PutMapping("/{userId}")
	public ResponseEntity<Void> putModifyUserInfo(
		    @PathVariable String userId,
		    // required = false로 지정하면 해당 파라미터가 누락되어도 에러가 발생하지 않습니다. 
		    // 따라서, 파일이나 닉네임, 비밀번호 중에서 변경할 정보가 없는 경우에도 정상적으로 처리됩니다.
		    @RequestParam(name = "userImageFile", required = false) MultipartFile userImageFile,
		    @RequestParam(name = "userNickname", required = false) String userNickname,
		    @RequestParam(name = "userPassword", required = false) String userPassword) {
		  
		  log.info("------------유저정보 수정----------");
		  log.info("userImageFile: " + userImageFile);
		  log.info("userNickname: " + userNickname);
		  log.info("userPassword: " + userPassword);

		  mypageService.modifyUserInfo(userImageFile, userNickname, userPassword, userId);

		  return ResponseEntity.ok().build();
	}
	
	// 회원정보 이미지 수정
	@PutMapping("/image/{userId}")
	public ResponseEntity<Void> putModifyUserImageInfo(
		    @PathVariable String userId,
		    // required = false로 지정하면 해당 파라미터가 누락되어도 에러가 발생하지 않습니다. 
		    // 따라서, 파일이나 닉네임, 비밀번호 중에서 변경할 정보가 없는 경우에도 정상적으로 처리됩니다.
		    @RequestParam(name = "userImageFile", required = false) MultipartFile userImageFile) {
		  
		  log.info("------------유저이미지 수정----------");
		  log.info("userImageFile: " + userImageFile);


		  mypageService.modifyUserImageInfo(userImageFile, userId);

		  return ResponseEntity.ok().build();
	}
	
	// 회원정보 비밀번호 수정
	@PutMapping("/pwd/{userId}")
	public ResponseEntity<Void> putModifyUserPasswordInfo(
		    @PathVariable String userId,
		    @RequestParam(name = "userPassword", required = false) String userPassword) {
		  
		  log.info("------------유저 비밀번호 수정----------");
		  log.info("userPassword: " + userPassword);

		  mypageService.modifyUserPasswordInfo(userPassword, userId);

		  return ResponseEntity.ok().build();
	}
	
	// 회원정보 닉네임 수정
	@PutMapping("/nickname/{userId}")
	public ResponseEntity<Void> modifyUserNicknameInfo(
		    @PathVariable String userId,
		    @RequestParam(name = "userNickname", required = false) String userNickname) {
		  
		  log.info("------------유저닉네임 수정----------");
		  log.info("userNickname: " + userNickname);

		  mypageService.modifyUserNicknameInfo(userNickname, userId);

		  return ResponseEntity.ok().build();
	}
	
	// 마이페이지 게시판 읽어오기
	@GetMapping("/boardlist")
	public String myBoardList (PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
		log.info("=============== boardService.getList를 호출 ===============");
		model.addAttribute("result", mypageService.getList(pageRequestDTO, userDetails.getUsername()));		
		log.info("=========================================================");
		log.info("리스트 결과값 : "+model.addAttribute("result"));

		log.info("모임정보 : "+model.addAttribute("clubDTO"));
	return "mypage/myboardlist";
	}    
	
	// 마이페이지 내가 가입한 모임 불러오기 
	@GetMapping("/myclub")
	public String myClubList(PageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		model.addAttribute("result", mypageService.getClubList(pageRequestDTO, userDetails.getUsername()));
		System.out.println("이거냐?" + model);
		return "mypage/myclublist";
	}
	
}
