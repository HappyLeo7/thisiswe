package com.thisiswe.home.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	// 인자로 넘어오는 userId를 db에서 찾아서 UserEntity에 넣겠다.
	Optional<UserEntity> findByUserId(String userId);
	Optional<UserEntity> findByUserNickname(String userNickname);
	Optional<UserEntity> findByUserPhoneNumber(String userPhoneNumber);
	Optional<UserEntity> findByKakaoId(Long kakaoId);
	
}
