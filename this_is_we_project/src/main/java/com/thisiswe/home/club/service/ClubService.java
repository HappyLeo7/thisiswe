package com.thisiswe.home.club.service;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.dto.PageRequestDTO;
import com.thisiswe.home.club.dto.PageResultDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.user.entity.UserEntity;

public interface ClubService {
	
	
	
	//DTO -> DB 등록
	Long register(ClubDTO clubDTO);
	
	// 1개의 모임 데이터를 불러온다
	ClubDTO get(Long clubNum);

	// 전체의 모임 데이터를 불러온다.
	Object getList(ClubDTO clubDTO);
	PageResultDTO<ClubDTO,Object[]> getPageList(PageRequestDTO pageRequestDTO);
	
	void modify(ClubDTO clubDTO);
	
	// CludDTO(Wed) -> ClubEntity(DB) 
	default ClubEntity dtoToEntity(ClubDTO clubDTO) {
		//모임번호, 지역, 모임명, 내용, 관심 카테고리, 로고이미지, 인원
		
		ClubEntity clubEntity = ClubEntity.builder()
				.clubNum(clubDTO.getClubNum()) //모임번호
				.userId(UserEntity.builder().userId(clubDTO.getUserId()).build()) //UserEntity에 등록 되어있는 userId가 들어와야 모임이 등록됨
				.clubPlace(clubDTO.getClubPlace())//지역
				.clubName(clubDTO.getClubName())//모임명
				.clubContent(clubDTO.getClubContent())//내용
				.clubCategory(clubDTO.getClubCategory())//관심 카테고리
				.clubLogo(clubDTO.getClubLogo())//로고
				.clubHeadCount(clubDTO.getClubHeadCount())//인원
				.build();
		
		
		return clubEntity;
		
	}
	
	
	
	
	// ClubEntity(DB) -> CludDTO(Wed)
	default ClubDTO entityToDTO (ClubEntity clubEntity, UserEntity userEntity) {
		//지역, 모임명, 내용, 관심 카테고리, 로고이미지, 인원
		ClubDTO clubDTO = ClubDTO.builder()
				.clubNum(clubEntity.getClubNum())
				.userId(userEntity.getUserId())
				.userNickname(userEntity.getUserNickname())
				.clubPlace(clubEntity.getClubPlace())
				.clubName(clubEntity.getClubName())
				.clubContent(clubEntity.getClubContent())
				.clubCategory(clubEntity.getClubCategory())
				.clubLogo(clubEntity.getClubLogo())
				.clubLogoUuid(clubEntity.getClubLogoUuid())
				.clubLogoUrl(clubEntity.getClubLogoUrl())
				.clubHeadCount(clubEntity.getClubHeadCount())
				.build();
		
		System.out.println("서비스 entitToDTO clubDTO :: "+clubDTO);
		return clubDTO;
		
	}

	















}
