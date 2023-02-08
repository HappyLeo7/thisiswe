package com.thisiswe.home.board.notice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//TODO [SearchRepository] 공지사항_검색
public interface SearchNoticeRepository {

	//TODO [SearchRepository] 공지사항_검색 : type, keyword, pageable
	Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
