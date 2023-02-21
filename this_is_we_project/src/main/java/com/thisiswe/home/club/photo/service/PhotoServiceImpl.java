package com.thisiswe.home.club.photo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.photo.dto.PhotoDTO;
import com.thisiswe.home.club.photo.entity.PhotoEntity;
import com.thisiswe.home.club.photo.repository.PhotoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService{
	
	
	private final PhotoRepository photoRepository;
	
	public void photoRegister(PhotoDTO photoDTO, MultipartFile multipartFile, ClubDTO clubDTO) throws Exception{
		log.info("...... photo register() ......");
		
		//파일경로
//		String path = "C:\\upload";
		String path = "C:\\upload";
		log.info("이미지 path 경로 : " +path);
		
		
		//랜덤 UUID 식별자
		UUID uuid = UUID.randomUUID();
		log.info("이미지 uuid : " +uuid);
		String photoName = uuid + "_" + multipartFile.getOriginalFilename();
		log.info("이미지 이름 : " +photoName);
		photoDTO.setPhotoImage(photoName);
		photoDTO.setPhotoPath(photoName);
		
		log.info("photoDTO : " +photoDTO);
		
		//지정한 폴더로 이미지 저장
		File saveFile = new File(path, photoName);
		log.info( "saveFile : "+saveFile);
		multipartFile.transferTo(saveFile);
		
		log.info( "clubDTO : "+clubDTO);
		
		PhotoEntity photoEntity = dtoToEntity(photoDTO, clubDTO);
		
		photoRepository.save(photoEntity);
		
		
		log.info("...... /photo register() ......");
		
	}
	
	public List<PhotoDTO> getPhotoList(Long clubNum ){
		log.info("..... get photo list .....");
		
		List<Object[]> photoLists = photoRepository.getPhotoList(clubNum);
		List<PhotoDTO> photoDTO = new ArrayList<PhotoDTO>();
		
		log.info(photoLists);
		for(Object[] photoList : photoLists) {
			PhotoEntity	photoEntity=(PhotoEntity)photoList[0];
			PhotoDTO photoDTOList=entityToDTO((PhotoEntity)photoEntity);
			log.info("photoDTO 1개정보 : "+photoDTOList);
			photoDTO.add(photoDTOList);
		}
		log.info("photoDTO : "+photoDTO);
		
		log.info("..... /get photo list .....");
		
		return photoDTO;
		
	}
	
	
}
