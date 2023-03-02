package com.thisiswe.home.place.repository;


import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.user.entity.UserEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {

	  @Query("select p, pi, avg(coalesce(pr.placeReviewRate, 0)), count(pr) from PlaceEntity p "
	  +" left outer join PlaceImageEntity pi on pi.placeNum = p "
	  +" left outer join PlaceReviewEntity pr on pr.placeNum = p group by p")
	  Page<Object[]> getListPage(Pageable pageable);
	 
	
	
	  @Query("select p, pi, avg(coalesce(pr.placeReviewRate, 0)), count(pr) from PlaceEntity p "
	  + " left outer join PlaceImageEntity pi on pi.placeNum = p " +
	  " left outer join PlaceReviewEntity pr on pr.placeNum = p " +
	  " where p.placeNum = :placeNum group by pi" )
	List<Object[]> getPlaceWithAll(Long placeNum);	

	List<PlaceEntity> findByUserId(UserEntity userId);
}

