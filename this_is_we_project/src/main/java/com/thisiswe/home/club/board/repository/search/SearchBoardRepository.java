package com.thisiswe.home.club.board.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//TODO [SearchBoard] 게시판_검색
public interface SearchBoardRepository {
	
	Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
