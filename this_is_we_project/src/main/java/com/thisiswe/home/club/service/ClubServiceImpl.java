package com.thisiswe.home.club.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.dto.PageRequestDTO;
import com.thisiswe.home.club.dto.PageResultDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.repository.ClubRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Service  //TODO service 부분을 사용하려면 꼭필요
@Log4j2
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

	private final ClubRepository clubrepository;
	
	@Override
	public Long register(ClubDTO clubDTO) {
		// TODO [모임등록 DTO->entity]club register
		log.info("====================================");
		log.info("==== ClubServiceImpl register() clubDTO : "+clubDTO+" ====");
		ClubEntity clubEntity = dtoToEntity(clubDTO);
		clubrepository.save(clubEntity);
		log.info("==== ClubServiceImpl register() clubEntity : "+clubEntity+" ====");
		log.info("====================================");
		
		//club num 모임 번호 리턴받아서 모임entity에 넣는다.
		return clubEntity.getClubNum();
	}

	@Override
	public PageResultDTO<ClubEntity, Object[]> getList(PageRequestDTO pageRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
