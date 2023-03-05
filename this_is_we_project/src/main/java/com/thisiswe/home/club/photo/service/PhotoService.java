package com.thisiswe.home.club.photo.service;

import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.photo.dto.PhotoDTO;
import com.thisiswe.home.club.photo.entity.PhotoEntity;
import com.thisiswe.home.user.entity.UserEntity;

public interface PhotoService {

	void photoRegister(PhotoDTO photoDTO, MultipartFile file, ClubDTO clubDTO) throws Exception;
	
	Object getPhotoList(Long clubNum);
	
	//DTO(wed) -> EN(DB)
	default PhotoEntity dtoToEntity(PhotoDTO photoDTO,ClubDTO clubDTO) {
		PhotoEntity photoEntity=PhotoEntity.builder()
				.photoImage(photoDTO.getPhotoImage())
				.photoContent(photoDTO.getPhotoContent())
				.photoPath(photoDTO.getPhotoPath())
				.userId(UserEntity.builder().userId(clubDTO.getUserId()).build())
				.clubNum(ClubEntity.builder().clubNum(clubDTO.getClubNum()).build())
			
				.build();
		System.out.println("사진서비스 DTO -> Entity 변환된 값 : "+photoEntity);
		return photoEntity;
	}
	
	//EN(DB) -> DTO(wed)
	default PhotoDTO entityToDTO(PhotoEntity photoEntity) {
		PhotoDTO photoDTO = PhotoDTO.builder()
					.photoNum(photoEntity.getPhotoNum())
					.clubNum(photoEntity.getClubNum())
					.userId(photoEntity.getUserId())
					.photoPath(photoEntity.getPhotoPath())
					.photoImage(photoEntity.getPhotoImage())
					.photoContent(photoEntity.getPhotoContent())
					.build();
					
		
		System.out.println("사진서비스 Entity -> DTO 변환된 값 : "+photoDTO);
		return photoDTO;
	}

	
	

}
