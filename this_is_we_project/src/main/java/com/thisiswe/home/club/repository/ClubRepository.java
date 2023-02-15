package com.thisiswe.home.club.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thisiswe.home.club.entity.ClubEntity;

public interface ClubRepository extends JpaRepository<ClubEntity, Long>{

	//Page<Object[]> getListPage(Pageable pageable);

	//List<Object[]> getClubWithAll(Long clubNum);

	/*
	@Query("select c, u, count(r) " +
		       " from ClubEntity c left join c.userId u " +
			   " left outer join Reply r on r.ClubEntity = c" +
		       " where c.userId = :userId")
		Object getBoardByBno(@Param("bno") Long bno);




	@Query("select c, u "
			+ "from UserEntity u "
			+ "left join ClubEntity c "
			+ "on u.userId = c "
			+ "where c.clubNum = :clubNum ")
	 getBoardByBno(@Param("clubNum") Long clubNum);


 */
	// 모임, 회원 1개의 정보 가져오기
	@Query("select c, u "
			+ "from ClubEntity c "
			+ "left join UserEntity u "
			+ "on c.userId = u.userId "
			+ "where c.clubNum = :clubNum ")
	List<Object[]> getClubNum(@Param("clubNum") Long clubNum);


	//모임 , 회원 DB 모두 가져오기
	@Query("select c, u "
			+ "from ClubEntity c "
			+ "left join UserEntity u "
			+ "on c.userId = u.userId ")
	List<Object[]> getClubList();

}
