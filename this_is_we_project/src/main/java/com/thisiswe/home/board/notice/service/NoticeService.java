package com.thisiswe.home.board.notice.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.board.notice.dto.NoticeDTO;

@Service

//TODO [Service] 공지사항
public interface NoticeService {

	//TODO [Service] 공지사항 - 등록(register)
	Long register(NoticeDTO dto);
	
	//TODO [Service] 공지사항 - 읽기(get)
	NoticeDTO get(Long notice_num);
}
