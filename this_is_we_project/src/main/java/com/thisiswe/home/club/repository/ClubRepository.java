package com.thisiswe.home.club.repository;



import java.util.List;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.repository.search.SearchClubRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClubRepository extends JpaRepository<ClubEntity, Long>, SearchClubRepository {

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
	//TODO [ClubRepository] 모임, 회원 정보 mysql 에서 1개 가져오는 쿼리문
	@Query("select c, u "
			+ "from ClubEntity c "
			+ "left join UserEntity u "
			+ "on c.userId = u.userId "
			+ "where c.clubNum = :clubNum ")
	List<Object[]> getClubNum(@Param("clubNum") Long clubNum);
	
	
	//TODO [ClubRepository] 모임리스트 , 모임등록한 회원 DB 가져오기
	@Query("select c, u "
			+ "from ClubEntity c "
			+ "left join UserEntity u "
			+ "on c.userId = u.userId ")
	List<Object[]> getClubList();

	//TODO [ClubRepository] 모임 삭제
	@Query(value = "delete from club_entity where club_num= 3 " ,nativeQuery = true)
	Long clubRemove(@Param("clubNum") Long clubNum);

	 
	
}
