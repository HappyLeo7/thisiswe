package com.thisiswe.home.place.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.thisiswe.home.place.dto.PlaceDTO;
import com.thisiswe.home.place.dto.PlaceImageDTO;
import com.thisiswe.home.place.dto.PlacePageRequestDTO;
import com.thisiswe.home.place.dto.PlacePageResultDTO;
import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceImageEntity;
import com.thisiswe.home.user.entity.UserEntity;


public interface PlaceService {

	Long register(PlaceDTO placeDTO);
	
	PlaceDTO getPlace(Long placeNum);
	
	public PlacePageResultDTO<PlaceDTO, Object[]> getList(PlacePageRequestDTO placePageRequestDTO);
	
	void modify(PlaceDTO placeDTO);

	void removeWithReplies(Long bno);

	
	
	default PlaceDTO entitiesToDTO(PlaceEntity placeEntity,List<PlaceImageEntity> placeImages ,Double placeAvg, Long placeReviewCount) {
		PlaceDTO placeDTO = PlaceDTO.builder()
				.placeNum(placeEntity.getPlaceNum())
				.placeName(placeEntity.getPlaceName())
				.placeOneLineIntroduction(placeEntity.getPlaceOneLineIntroduction())
				.placeIntroduction(placeEntity.getPlaceIntroduction())
				.placeBusinessHours(placeEntity.getPlaceBusinessHours())
				.placeHoliday(placeEntity.getPlaceHoliday())
				.placeRefundRegulations(placeEntity.getPlaceRefundRegulations())
				.placeAddress(placeEntity.getPlaceAddress())
				.placePhoneNumber(placeEntity.getPlacePhoneNumber())
				.placeCategory(placeEntity.getPlaceCategory())
				.placeGuide(placeEntity.getPlaceGuide())
				.placeCaution(placeEntity.getPlaceCaution())
				.placeRegDate(placeEntity.getRegDate())
				.placeUpdateDate(placeEntity.getUpdateDate())
				.build();
				
		List<PlaceImageDTO> placeImageDTOList = placeImages.stream().map(placeImage->{
			if(placeImage != null) {
				return PlaceImageDTO.builder()
						.placeImgName(placeImage.getPlaceImageName())
						.placeImageUrl(placeImage.getPlaceImageUrl())
						.placeUuid(placeImage.getPlaceImageUuid())
						.build();
			}
			return null;
		}).collect(Collectors.toList());
		
		placeDTO.setPlaceImageDTOList(placeImageDTOList);
		placeDTO.setPlaceAvg(placeAvg);
		placeDTO.setPlaceReviewCount(placeReviewCount.intValue());
		
		return placeDTO;
	}
	
	default Map<String, Object> DTOtoEntity(PlaceDTO placeDTO) {
		Map<String, Object> entityMap = new HashMap<>();
		
		PlaceEntity placeEntity = PlaceEntity.builder()
				.placeNum(placeDTO.getPlaceNum())
				.placeName(placeDTO.getPlaceName())
				.userId(UserEntity.builder().userId(placeDTO.getUserId()).build())
				.placeOneLineIntroduction(placeDTO.getPlaceOneLineIntroduction())
				.placeIntroduction(placeDTO.getPlaceIntroduction())
				.placeBusinessHours(placeDTO.getPlaceBusinessHours())
				.placeHoliday(placeDTO.getPlaceHoliday())
				.placeRefundRegulations(placeDTO.getPlaceRefundRegulations())
				.placeAddress(placeDTO.getPlaceAddress())
				.placePhoneNumber(placeDTO.getPlacePhoneNumber())
				.placeCategory(placeDTO.getPlaceCategory())
				.placeGuide(placeDTO.getPlaceGuide())
				.placeCaution(placeDTO.getPlaceCaution())
				.build();
		entityMap.put("place", placeEntity);
		
		List<PlaceImageDTO> placeImageDTOList= placeDTO.getPlaceImageDTOList();
		
		if(placeImageDTOList != null && placeImageDTOList.size() > 0) {
			List<PlaceImageEntity> placeImageList = placeImageDTOList.stream().map(placeImageDTO->{
				PlaceImageEntity placeImage = PlaceImageEntity.builder()
						.placeImageUrl(placeImageDTO.getPlaceImageURL())
						.placeImageName(placeImageDTO.getPlaceImgName())
						.placeImageUuid(placeImageDTO.getPlaceUuid())
						.placeNum(placeEntity)
						.build();
				return placeImage;
			}).collect(Collectors.toList());
			
			entityMap.put("placeImgList", placeImageList);
			
		}
		return entityMap;
		
	}

}
