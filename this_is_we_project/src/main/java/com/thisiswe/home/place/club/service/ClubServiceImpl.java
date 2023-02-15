package com.thisiswe.home.place.club.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.transaction.Transactional;

import com.thisiswe.home.place.club.dto.ClubDTO;
import com.thisiswe.home.place.club.entity.ClubEntity;
import com.thisiswe.home.place.club.repository.ClubRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thisiswe.home.place.club.dto.PageRequestDTO;
import com.thisiswe.home.place.club.dto.PageResultDTO;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Service  //TODO service 부분을 사용하려면 꼭필요
@Log4j2
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

	private final ClubRepository clubRepository;
	
	
	// 모임 등록 하는 매서드
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
		log.info("[[[[[[[getList매서드");
		System.out.println("[[[[[서비스 Impl테스트중]]]]]");
		List<Object[]> list = clubRepository.getClubList();
		List<ClubDTO> entList = new ArrayList<>(); 
		System.out.println("list:::::::"+list);
		for (Object[] arr : list) {
			entList.add( entityToDTO((ClubEntity)arr[0], (UserEntity)arr[1]));
		}
		return entList;
		
	}
	
	@Override
	public PageResultDTO<ClubDTO, Object[]> getPageList(PageRequestDTO pageRequestDTO) {

		log.info("===== getPageList() pageRequestDTO =====");
		Function<Object[], ClubDTO> fn = (en->
				entityToDTO((ClubEntity)en[0],(UserEntity)en[1]));
	
		//Page<Object[]> result = clubRepository.getBoardWithReplyCount(
		//pageRequestDTO.getPageable(Sort.by("bno").descending()));
		
		
		Page<Object[]> result = clubRepository.searchPage(
				pageRequestDTO.getType(),
				pageRequestDTO.getKeyword(),
				pageRequestDTO.getPageable(Sort.by("clubNum").descending()));
				
		return new PageResultDTO<>(result, fn);
	}



	//상세 페이지 1개 가져오는 매서드
	@Override
	public ClubDTO get(Long clubNum) {
		log.info("[[[[[[[get매서드");
		System.out.println("서비스Impl clubNum: "+clubNum);
		Object clubEntityObject = clubRepository.getClubNum(clubNum);
		
		List<Object[]> arr= (List<Object[]>) clubEntityObject;
		
		return entityToDTO((ClubEntity)arr.get(0)[0], (UserEntity)arr.get(0)[1]);
	}



	
	// 모임 수정하는 매서드
	@Transactional
	@Override
	public void modify(ClubDTO clubDTO) {
		System.out.println("서비스Impl 테스트 1");
		log.info("modify() 수정 메서드");
		
		ClubEntity clubEntity = clubRepository.getById(clubDTO.getClubNum());
		log.info( "서비스수정할값 :  "+clubEntity);
		if(clubEntity != null) {
			clubEntity.change(
					clubDTO.getClubPlace(),
					clubDTO.getClubName(), 
					clubDTO.getClubContent(), 
					clubDTO.getClubCategory(), 
					clubDTO.getClubLogo(),
					clubDTO.getClubLogoUuid(), 
					clubDTO.getClubLogoUrl(),
					clubDTO.getClubHeadCount()
					);
		}
		log.info("수정된 clubEntity : "+clubEntity);
		clubRepository.save(clubEntity);
		
	}




	
 








	



}
