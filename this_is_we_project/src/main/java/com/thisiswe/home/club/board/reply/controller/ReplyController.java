package com.thisiswe.home.club.board.reply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 게시판-댓글
public class ReplyController {

	private final ReplyService replyService;
	
	//TODO [Controller] 게시판-댓글 : 목록 불러오기
	@GetMapping(value = "/club/board/{boardNum}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("boardNum") Long boardNum) {
		
		log.info("=========================================================");
		log.info("================= boardNum =================> " + boardNum);
		log.info("=========================================================");
		
		return new ResponseEntity<>(replyService.getList(boardNum), HttpStatus.OK);	
	}
	
	//TODO [Controller] 게시판-댓글 : 등록
	@PostMapping("")
	public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO) {
		log.info("=========================================================");
		log.info("=========== boardReplyController ===========> " + replyDTO);
		
		Long boardReplyNum = replyService.register(replyDTO);
		log.info("============ boardReplyNum ============> " + boardReplyNum);
		log.info("=========================================================");
		
		return new ResponseEntity<Long>(boardReplyNum, HttpStatus.OK);
	}
	
	//TODO [Controller] 게시판-댓글 : 수정
	@PutMapping("/{boardReplyNum}")
	public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO) {
		
		log.info("=========================================================");
		log.info("================= replyDTO =================> " + replyDTO);
		replyService.modify(replyDTO);
		log.info("=========================================================");
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	//TODO [Controller] 게시판-댓글 : 삭제
	@DeleteMapping("/{boardReplyNum}")
	public ResponseEntity<String> remove(@PathVariable("boardReplyNum") Long boardReplyNum) {
		
		log.info("=========================================================");
		log.info("============ boardReplyNum ============> " + boardReplyNum);
		replyService.remove(boardReplyNum);
		log.info("=========================================================");
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
