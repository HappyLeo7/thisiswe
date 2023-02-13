package com.thisiswe.home.club.service;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.dto.PageRequestDTO;
import com.thisiswe.home.club.dto.PageResultDTO;
import com.thisiswe.home.club.entity.ClubEntity;

public interface ClubService {

	Long register(ClubDTO clubDTO);
	
	PageResultDTO<ClubEntity, Object[]> getList(PageRequestDTO pageRequestDTO);
	
	// CludDTO(Wed) -> ClubEntity(DB) 
	default ClubEntity dtoToEntity(ClubDTO clubDTO) {
		//지역, 모임명, 내용, 관심 카테고리, 로고이미지, 인원
		ClubEntity clubEntity = ClubEntity.builder()
				
				.clubPlace(clubDTO.getClubPlace())
				.clubName(clubDTO.getClubName())
				.clubContent(clubDTO.getClubContent())
				.clubCategory(clubDTO.getClubCategory())
				.clubLogo(clubDTO.getClubLogo())
				.clubHeadCount(clubDTO.getClubHeadCount())
				.build();
		
		return clubEntity;
		
	}
	
	// ClubEntity(DB) -> CludDTO(Wed)
	default ClubDTO entitToDTO (ClubEntity clubEntity) {
		//지역, 모임명, 내용, 관심 카테고리, 로고이미지, 인원
		ClubDTO clubDTO = ClubDTO.builder()
				.clubPlace(clubEntity.getClubPlace())
				
				.build();
		return clubDTO;
		
	}
}
