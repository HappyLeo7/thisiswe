package com.thisiswe.home.club.member;

import com.thisiswe.home.user.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.thisiswe.home.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClubMemberService {

	private final ClubMemberRepository clubMemberRepository;
	
	public boolean clubMemberRegister( String userId, ClubMemberDTO clubMemberDTO) {
		Long clubNum = clubMemberDTO.getClubNum();
		ClubMemberEntity clubMemberEntity=ClubMemberEntity.builder()
				.userId(UserEntity.builder().userId(userId).build())
				.clubMemberRole(clubMemberDTO.getClubMemberRole())
				.clubNum(clubNum)
				.build();

		//값이 없을 경우에 저장
		if(!checkMember(clubNum,userId)) {
			//없을경우 true
			clubMemberRepository.save(clubMemberEntity);
			return true;
		}else {
			//있을경우 false
			return false;
		}
	}

	//멤버 체크 (clubnum , userId) 리턴: boolean
	public boolean checkMember(Long clubNum, String userId){
		System.out.println("userId : " + userId);
		System.out.println("clubNum : " + clubNum);
		return clubMemberRepository.existsByClubNumAndUserId(clubNum, UserEntity.builder().userId(userId).build());
	}
	
}
