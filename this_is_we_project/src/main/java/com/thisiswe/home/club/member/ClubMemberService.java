package com.thisiswe.home.club.member;

import org.springframework.stereotype.Service;

import com.thisiswe.home.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClubMemberService {

	private final ClubMemberRepository clubMemberRepository;
	
	public void clubMemberRegister(ClubMemberDTO clubMemberDTO) {
			
		ClubMemberEntity clubMemberEntity=ClubMemberEntity.builder()
				.userId(UserEntity.builder().userId(clubMemberDTO.getUserID()).build())
				.clubMemberRole(clubMemberDTO.getClubMemberRole())
				.clubNum(clubMemberDTO.getClubNum())
				.build();
		
		clubMemberRepository.save(clubMemberEntity);
	}
	
}
