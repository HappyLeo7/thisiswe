package com.thisiswe.home.place.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thisiswe.home.place.entity.PlaceEntity;

public interface SearchPlaceRepository {

	PlaceEntity search1();
	
	Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
