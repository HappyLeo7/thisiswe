package com.thisiswe.home.club.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;

public interface ClubService {

	Long register(ClubDTO clubDTO);
	
	
	//ClubEntity(DB) -> CludDTO(Wed)
	default ClubEntity dtoToEntity(ClubDTO clubDTO) {
		//지역, 모임명, 내용, 관심 카테고리, 로고이미지, 인원
		ClubEntity clubEntity = ClubEntity.builder()
				.clubPlace(clubDTO.getClubPlace())
				.club_name(clubDTO.getClubName())
				.club_content(clubDTO.getClubContent())
				.club_category(clubDTO.getClubCategory())
				.club_logo(clubDTO.getClubLogo())
				.club_head_count(clubDTO.getClubHeadCount())
				.build();
		
		return clubEntity;
		
	}
	
	//CludDTO(Wed) -> ClubEntity(DB)
	default ClubDTO entitToDTO (ClubEntity clubEntity) {
		//지역, 모임명, 내용, 관심 카테고리, 로고이미지, 인원
		ClubDTO clubDTO = ClubDTO.builder()
				
				.build();
		return clubDTO;
		
	}
}
