package com.thisiswe.home.board.free.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisiswe.home.board.free.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 
public class BoardController {
	
	private BoardService boardService;

}
