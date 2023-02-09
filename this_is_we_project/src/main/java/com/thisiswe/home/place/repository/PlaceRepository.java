package com.thisiswe.home.place.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.user.entity.UserEntity;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {

	List<PlaceEntity> findByUserId(UserEntity userId);	

}
