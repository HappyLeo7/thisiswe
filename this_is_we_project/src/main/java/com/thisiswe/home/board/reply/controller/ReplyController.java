package com.thisiswe.home.board.reply.controller;

import com.thisiswe.home.board.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller]
public class ReplyController {

	private final ReplyService replyService;
	
}
