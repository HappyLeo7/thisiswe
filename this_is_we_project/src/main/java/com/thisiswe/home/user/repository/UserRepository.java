package com.thisiswe.home.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	boolean existsByUserId(String userId);
	boolean existsByUserNickname(String userNickname);
	
	// 인자로 넘어오는 userId를 db에서 찾아서 UserEntity에 넣겠다.
	// 변수명은 항상 Entity와 일치시켜야한다.
	Optional<UserEntity> findByUserId(String userId);
	Optional<UserEntity> findByUserNickname(String userNickname);
	Optional<UserEntity> findByUserName(String userName);
	Optional<UserEntity> findByUserEmail(String userEmail);
	Optional<UserEntity> findByUserPhoneNumber(String userPhoneNumber);
	Optional<UserEntity> findByKakaoId(Long kakaoId);

	
}

