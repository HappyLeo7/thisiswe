package com.thisiswe.home.club.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.repository.ClubRepository;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Service  //TODO service 부분을 사용하려면 꼭필요
@Log4j2
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

	private final ClubRepository clubRepository;
	
	
	@Override
	public Long register(ClubDTO clubDTO) {
		log.info("등록 :: " + clubDTO);
		ClubEntity clubEntity  = dtoToEntity(clubDTO);
		clubRepository.save(clubEntity);
		
		return clubEntity.getClubNum();
		
	}




	//TODO [리스트]clublist 출력해주는메서드
	@Override
	public List<ClubDTO> getList(ClubDTO clubDTO) {
		System.out.println("[[[[[서비스 Impl테스트중]]]]]");
		List<Object[]> list = clubRepository.getClubList();
		List<ClubDTO> entList = new ArrayList<>(); 
		System.out.println("aaaA:::::::"+list);
		for (Object[] arr : list) {
			entList.add( entitToDTO((ClubEntity)arr[0], (UserEntity)arr[1]));
		}
		return entList;
		
	}



	//상세 페이지 1개 가져오는 매서드
	@Override
	public ClubDTO get(Long clubNum) {
		System.out.println(clubNum);
		System.out.println("1111");
		Object clubEntityObject = clubRepository.getClubNum(clubNum);
		
		List<Object[]> arr= (List<Object[]>) clubEntityObject;
		System.out.println("2222"+arr);
		System.out.println("333");
		//return null;
		return entitToDTO((ClubEntity)arr.get(0)[0], (UserEntity)arr.get(0)[1]);
	}









	



}
