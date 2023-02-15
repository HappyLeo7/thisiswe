package com.thisiswe.home.place.club.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchClubRepository {
    
    Page<Object[]> 
        searchPage(String type, String keyword, Pageable pageable);
}
