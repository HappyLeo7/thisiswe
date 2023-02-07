package com.thisiswe.home.club.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;

import lombok.extern.log4j.Log4j2;



@Service  //TODO service 부분을 사용하려면 꼭필요
@Log4j2

public class ClubServiceImpl implements ClubService {

	@Override
	public Long register(ClubDTO clubDTO) {
		// TODO [모임등록 DTO->entity]club register
		ClubEntity clubEntity = dtoToEntity(clubDTO);
		
		
		return null;
	}

}
