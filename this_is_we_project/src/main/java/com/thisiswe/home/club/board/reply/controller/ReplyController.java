
package com.thisiswe.home.club.board.reply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thisiswe.home.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.club.board.reply.service.ReplyService;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("club/board/review/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 게시판-댓글
public class ReplyController {

	private final ReplyService replyService;
	
	//TODO [Controller] 게시판-댓글 : 목록 불러오기
	@GetMapping(value = "/{boardNum}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("boardNum") Long boardNum) {
		
		log.info("[ReplyController][list]==================================");
		log.info("[ReplyController][list] boardNum ========> :: " + boardNum);
		log.info("/[ReplyController][list]=================================");
		
		return new ResponseEntity<>(replyService.getList(boardNum), HttpStatus.OK);	
	}
	
	//TODO [Controller] 게시판-댓글 : 등록
	@PostMapping("")
	public ResponseEntity<Long> register(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
										 @RequestBody ReplyDTO replyDTO) {
		
		log.info("[ReplyController][register]==============================");
		/** html json 에서 유저 정보를 넣지 않고, Controller에서 세팅해준다. */
		replyDTO.setUserId(userDetailsImpl.getUsername());		
		log.info("[ReplyController][register] replyDTO ====> :: " + replyDTO);
		
		Long boardReplyNum = replyService.register(replyDTO);
		log.info("[ReplyController][register] boardReplyNum ====> :: " + boardReplyNum);
		log.info("/[ReplyController][register]==============================");
		
		return new ResponseEntity<Long>(boardReplyNum, HttpStatus.OK);
	}
	
	//TODO [Controller] 게시판-댓글 : 수정
	@PutMapping("/{boardReplyNum}")
	public ResponseEntity<Long> modify(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
									   @RequestBody ReplyDTO replyDTO) {
		
		log.info("[ReplyController][modify]================================");
		/** html json 에서 유저 정보를 넣지 않고, Controller에서 세팅해준다. */
		replyDTO.setUserId(userDetailsImpl.getUsername());		
		log.info("[ReplyController][modify] replyDTO ======> :: " + replyDTO);
		
		Long boardReplyNum = replyService.register(replyDTO);
		log.info("/[ReplyController][modify]===============================");
		
		return new ResponseEntity<>(boardReplyNum, HttpStatus.OK);
	}
	
	//TODO [Controller] 게시판-댓글 : 삭제
	@DeleteMapping("/{boardReplyNum}")
	public ResponseEntity<String> remove(@PathVariable Long boardReplyNum) {
		
		log.info("[ReplyController][remove]================================");
		log.info("[ReplyController][remove] boardReplyNum ====> :: " + boardReplyNum);
		
		replyService.remove(boardReplyNum);
		log.info("/[ReplyController][remove]===============================");
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
}