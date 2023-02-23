package com.thisiswe.home.place.repository;


import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {

	List<PlaceEntity> findByUserId(UserEntity userId);	

}
