package com.thisiswe.home.notice.service;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.thisiswe.home.notice.dto.NoticeDTO;
import com.thisiswe.home.notice.dto.PageRequestDTO;
import com.thisiswe.home.notice.dto.PageResultDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

//TODO [ServiceImpl] 공지사항
public class NoticeServiceImpl implements NoticeService{
	
	@Override
	public Long list(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	
	//TODO [ServiceImpl] 공지사항 - 페이지 목록 불러오기
	*/
	
}
