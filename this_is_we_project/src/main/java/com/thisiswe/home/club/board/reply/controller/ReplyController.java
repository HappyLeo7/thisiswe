package com.thisiswe.home.club.board.reply.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thisiswe.home.club.board.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller]
public class ReplyController {

	private final ReplyService replyService;
	
}
