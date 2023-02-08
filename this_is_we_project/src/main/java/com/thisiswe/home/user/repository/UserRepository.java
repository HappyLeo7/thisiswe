package com.thisiswe.home.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	// 회원가입시 중복된 회원이 있는지 검사하기 위해 아이디를 통해 회원을 검사하는 메서드
	UserEntity findByUserId(String userId);
	
	// :social은 파라미터를 나타낸다.
//	@EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
//	@Query("select m from userEntity m where m.fromSocial = :social and m.email = :email")
//	Optional<UserEntity> findByEmail(String email, Boolean social);
}
