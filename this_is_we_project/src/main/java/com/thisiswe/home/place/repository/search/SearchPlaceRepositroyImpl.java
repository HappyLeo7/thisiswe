package com.thisiswe.home.place.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.QPlaceEntity;
import com.thisiswe.home.place.entity.QPlaceReviewEntity;
import com.thisiswe.home.user.entity.QUserEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SearchPlaceRepositroyImpl extends QuerydslRepositorySupport implements SearchPlaceRepository {

	public SearchPlaceRepositroyImpl() {
		super(Board.class);
	}

	@Override
	public PlaceEntity search1() {
		log.info("place Search1.........");
		return null;
	}

	@Override
	public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
		
		log.info("searchPlace.......");
		
		QPlaceEntity place = QPlaceEntity.placeEntity;
		QPlaceReviewEntity placeReview  = QPlaceReviewEntity.placeReviewEntity;
		QUserEntity userEntity = QUserEntity.userEntity;
		return null;
	}

}
