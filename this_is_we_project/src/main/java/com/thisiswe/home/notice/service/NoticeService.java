package com.thisiswe.home.notice.service;

import com.thisiswe.home.notice.dto.NoticeDTO;
import com.thisiswe.home.notice.dto.PageRequestDTO;
import com.thisiswe.home.notice.dto.PageResultDTO;

public interface NoticeService {

	Long list(NoticeDTO noticeDTO);
	
	/*
	//TODO [Service] 공지사항 - 페이지 불러오기(pageResult)	
	PageResultDTO<NoticeDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
	 */
}
