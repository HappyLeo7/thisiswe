package com.thisiswe.home.board.notice.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.board.notice.dto.NoticeDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

//TODO [ServiceImpl] 공지사항
public class NoticeServiceImpl implements NoticeService{
	
	//private final NoticeService noticeService;
	
	@Override
	public Long register(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeDTO get(Long notice_num) {
		// TODO Auto-generated method stub
		return null;
	}

}
