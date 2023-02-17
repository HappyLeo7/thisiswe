package com.thisiswe.home.notice.service;

import com.thisiswe.home.notice.dto.NoticeDTO;

public interface NoticeService {

	Long list(NoticeDTO noticeDTO);
	
	/*
	//TODO [Service] 공지사항 - 페이지 불러오기(pageResult)	
	PageResultDTO<NoticeDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
	 */
}
