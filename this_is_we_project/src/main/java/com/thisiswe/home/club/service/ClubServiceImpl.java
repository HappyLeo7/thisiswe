package com.thisiswe.home.club.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.chat.service.ChatService;
import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.dto.PageRequestDTO;
import com.thisiswe.home.club.dto.PageResultDTO;
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
	private final ChatService chatService;
	
	
	// 모임 등록 하는 매서드
	@Override
	public Long register(ClubDTO clubDTO, MultipartFile multipartFile) throws Exception{
		
		
		
		
		// TODO [모임등록 DTO->entity]club register
		log.info("..... ClubServiceImpl register()   .....");
		
		log.info("///// 모임 로고 이미지 등록처리 /////");
		
		String path = "C:\\upload";
		
		UUID uuid = UUID.randomUUID();
		String logoName = uuid+"_"+multipartFile.getOriginalFilename();
		clubDTO.setClubLogo(multipartFile.getOriginalFilename());
		clubDTO.setClubLogoUuid(logoName);
		clubDTO.setClubLogoUrl(logoName);
		
		
		File saveFile = new File(path,logoName);
		multipartFile.transferTo(saveFile);
		
		log.info(".....  clubDTO : "+clubDTO+" .....");
		ClubEntity clubEntity = dtoToEntity(clubDTO);
		clubRepository.save(clubEntity);
		chatService.createChattingRoom(clubEntity.getClubName());//모임생성시 모임 이름 채팅방에 저장
		log.info("==== ClubServiceImpl register() clubEntity : "+clubEntity+" ====");
		

		
		
		log.info("..... /ClubServiceImpl register()  .....");
		
		//club num 모임 번호 리턴받아서 모임entity에 넣는다.
		return clubEntity.getClubNum();
		
	}




	//TODO [리스트]clublist 출력해주는메서드
	@Override
	public List<ClubDTO> getList(ClubDTO clubDTO) {
		log.info("...... getList() ......");
		System.out.println("[모임 서비스 Impl]");
		List<Object[]> list = clubRepository.getClubList();
		List<ClubDTO> entList = new ArrayList<>(); 
		System.out.println(" .... club list : "+list);
		for (Object[] arr : list) {
			entList.add( entityToDTO((ClubEntity)arr[0], (UserEntity)arr[1]));
			
		}
		log.info("entList : " +entList);
		log.info("...... /getList() ......" );
		return entList;
		
	}
	
	@Override
	public PageResultDTO<ClubDTO, Object[]> getPageList(PageRequestDTO pageRequestDTO) {

		log.info("...... getPageList() pageRequestDTO ......");
		log.info("pageRequestDTO : " +pageRequestDTO);
		
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



	//모임상세 페이지 1개 가져오는 매서드
	@Override
	public ClubDTO get(Long clubNum) {
		log.info("........get()........");
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
