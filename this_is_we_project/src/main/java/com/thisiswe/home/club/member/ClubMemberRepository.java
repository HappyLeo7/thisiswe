package com.thisiswe.home.club.member;



import java.util.List;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.repository.search.SearchClubRepository;
import com.thisiswe.home.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClubMemberRepository extends JpaRepository<ClubMemberEntity, Long>, SearchClubRepository {

    //추가
    boolean existsByClubNumAndUserId(Long clubNum, UserEntity userEntity);
}
