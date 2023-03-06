package com.thisiswe.home.club.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import javax.transaction.Transactional;

import com.thisiswe.home.s3.FileRequestDto;
import com.thisiswe.home.s3.S3Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.chat.service.ChatService;
import com.thisiswe.home.club.calendar.entity.CalendarEntity;
import com.thisiswe.home.club.calendar.repository.CalendarRepository;
import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.dto.PageRequestDTO;
import com.thisiswe.home.club.dto.PageResultDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.repository.ClubRepository;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service // TODO service 부분을 사용하려면 꼭필요
@Log4j2
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

	private final S3Service s3Service;
	private final ClubRepository clubRepository;
	private final ChatService chatService;
	private final CalendarRepository calendarRepository;

	// 모임 등록 하는 매서드
	@Override
	public Long register(ClubDTO clubDTO, MultipartFile multipartFile) throws Exception {

		// TODO [모임등록 DTO->entity]club register
		log.info("..... ClubServiceImpl register()   .....");

		log.info("///// 모임 로고 이미지 등록처리 /////");

//		String path = "C:\\upload";
//
//		UUID uuid = UUID.randomUUID();
//		String logoName = uuid + "_" + multipartFile.getOriginalFilename();

//		clubDTO.setClubLogo(multipartFile.getOriginalFilename());
//		clubDTO.setClubLogoUuid(logoName);
//		clubDTO.setClubLogoUrl(logoName);
//
//		File saveFile = new File(path, logoName);

//		multipartFile.transferTo(saveFile);
		FileRequestDto fileRequestDto = s3Service.upload(multipartFile);
		String imageUrl = fileRequestDto.getImageUrl();
		clubDTO.setClubLogo(imageUrl);
		clubDTO.setClubLogoUuid(imageUrl);
		clubDTO.setClubLogoUrl(imageUrl);
//
		log.info(".....  clubDTO : " + clubDTO + " .....");
		ClubEntity clubEntity = dtoToEntity(clubDTO);
		clubRepository.save(clubEntity);

		chatService.createChattingRoom(clubEntity.getClubName());// 모임생성시 모임 이름 채팅방에 저장
		log.info("==== ClubServiceImpl register() clubEntity : " + clubEntity + " ====");

		CalendarEntity calendarEntity = CalendarEntity.builder().clubNum(clubEntity)
				.clubCalendarTitle("'" + clubEntity.getClubName() + "'의 모임 생일").clubCalendarDate("0")
				.clubCalendarContent("0").clubCalendarHeadCount(1L).clubCalendarTime("00:00").clubCalendarPlace("0000")
				.clubCalendarPrice(0L).build();

		calendarRepository.save(calendarEntity);

		log.info(calendarEntity);

		log.info("..... /ClubServiceImpl register()  .....");

		// club num 모임 번호 리턴받아서 모임entity에 넣는다.
		return clubEntity.getClubNum();

	}

	// TODO [리스트]clublist 출력해주는메서드
	@Override
	public List<ClubDTO> getList(ClubDTO clubDTO) {
		log.info("...... getList() ......");
		System.out.println("[모임 서비스 Impl]");
		List<Object[]> list = clubRepository.getClubList();
		List<ClubDTO> entList = new ArrayList<>();
		System.out.println(" .... club list : " + list);

		try {

			for (Object[] arr : list) {
				entList.add(entityToDTO((ClubEntity) arr[0], (UserEntity) arr[1]));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.info("entList : " + entList);
		log.info("...... /getList() ......");
		return entList;

	}

	@Override
	public PageResultDTO<ClubDTO, Object[]> getPageList(PageRequestDTO pageRequestDTO) {

		log.info("...... getPageList() pageRequestDTO ......");
		log.info("pageRequestDTO : " + pageRequestDTO);

		Function<Object[], ClubDTO> fn = (en -> entityToDTO((ClubEntity) en[0], (UserEntity) en[1]));

		// Page<Object[]> result = clubRepository.getBoardWithReplyCount(
		// pageRequestDTO.getPageable(Sort.by("bno").descending()));

		Page<Object[]> result = clubRepository.searchPage(pageRequestDTO.getType(), pageRequestDTO.getKeyword(),
				pageRequestDTO.getPageable(Sort.by("clubNum").descending()));

		return new PageResultDTO<>(result, fn);
	}

	// 모임상세 페이지 1개 가져오는 매서드
	@Override
	public ClubDTO get(Long clubNum) {
		log.info("........get()........");
		log.info("........clubNum : " + clubNum);

		Object clubEntityObject = clubRepository.getClubNum(clubNum);

		List<Object[]> arr = (List<Object[]>) clubEntityObject;
		log.info("........arr.get(0)[0]  : " + arr.get(0)[0]);
		log.info("........arr.get(0)[1]  : " + arr.get(0)[1]);

		return entityToDTO((ClubEntity) arr.get(0)[0], (UserEntity) arr.get(0)[1]);
	}

	// 모임 수정하는 매서드
	@Transactional
	@Override
	public void modify(ClubDTO clubDTO, MultipartFile file) throws Exception {
		System.out.println("서비스Impl 테스트 1");
		log.info("modify() 수정 메서드 : " + file.getOriginalFilename());

		if (file.getOriginalFilename() != "") {

			log.info("..... ClubServiceImpl modify()   .....");
			log.info("///// 모임 로고 이미지 등록처리 /////");
			String path = "C:\\upload";

			UUID uuid = UUID.randomUUID();
			String photoName = uuid + "_" + file.getOriginalFilename();
			log.info("이미지 이름 : " + photoName);

			clubDTO.setClubLogo(file.getOriginalFilename());
			clubDTO.setClubLogoUuid(photoName);
			clubDTO.setClubLogoUrl(photoName);

			// 지정한 폴더로 이미지 저장
			File saveFile = new File(path, photoName);
			log.info("saveFile : " + saveFile);
			file.transferTo(saveFile);

			log.info("clubDTO 로고 이름이 들어가있는지 테스트 : " + clubDTO.getClubLogo());

			ClubEntity clubEntity = clubRepository.getById(clubDTO.getClubNum());
			log.info("서비스수정할값 :  " + clubEntity);
			if (clubEntity != null) {
				clubEntity.changeLogo(clubDTO.getClubPlace(), clubDTO.getClubName(), clubDTO.getClubContent(),
						clubDTO.getClubCategory(), clubDTO.getClubLogo(), clubDTO.getClubLogoUuid(),
						clubDTO.getClubLogoUrl(), clubDTO.getClubHeadCount());
			}
			log.info("수정된 clubEntity : " + clubEntity);
			clubRepository.save(clubEntity);
		} else {

			ClubEntity clubEntity = clubRepository.getById(clubDTO.getClubNum());
			log.info("서비스수정할값 :  " + clubEntity);
			if (clubEntity != null) {
				clubEntity.change(clubDTO.getClubPlace(), clubDTO.getClubName(), clubDTO.getClubContent(),
						clubDTO.getClubCategory(), clubDTO.getClubHeadCount());
			}
			log.info("수정된 clubEntity : " + clubEntity);
			clubRepository.save(clubEntity);

		}

	}

}
