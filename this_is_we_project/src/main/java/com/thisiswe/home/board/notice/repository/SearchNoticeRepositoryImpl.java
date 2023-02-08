package com.thisiswe.home.board.notice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import lombok.extern.log4j.Log4j2;

@Log4j2
//TODO [SearchRepositoryImpl] 공지사항_검색
public class SearchNoticeRepositoryImpl extends QuerydslRepositorySupport implements SearchNoticeRepository {

	public SearchNoticeRepositoryImpl() {
		super(NoticeRepository.class);
	}

	//TODO [SearchRepositoryImpl] 공지사항_검색 : type, keyword, pageable
	@Override
	public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
		
		/*
		 * log.info("=========================================================");
		 * log.info("====================== searchPage ======================");
		 * 
		 * JPQLQuery<Notice> jpqlQuery = from(notice);
		 */
	
		return null;
	}

}
