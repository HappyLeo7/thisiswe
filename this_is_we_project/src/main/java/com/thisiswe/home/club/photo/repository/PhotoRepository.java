package com.thisiswe.home.club.photo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thisiswe.home.club.photo.entity.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

	
	@Query("select pt, c "
			+ "from ClubEntity c "
			+ "left join PhotoEntity pt "
			+ "on pt.clubNum=c.clubNum "
			+ "where c.clubNum= :clubNum ")
	List<Object[]> getPhotoList(@Param("clubNum") Long clubNum);
	
}
