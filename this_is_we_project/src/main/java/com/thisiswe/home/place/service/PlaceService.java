package com.thisiswe.home.place.service;

import java.util.List;

import com.thisiswe.home.place.dto.PlaceDTO;
import com.thisiswe.home.place.entity.PlaceEntity;

public interface PlaceService {

	Long register(PlaceDTO placeDTO);
	
	PlaceDTO read(Long placeNum);
	
	List<PlaceDTO> getList();
	
	void modify(PlaceDTO placeDTO);

	void removeWithReplies(Long bno);

	
	
	default PlaceDTO entityToDTO(PlaceEntity placeEntity) {
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
				.placeCoordinate(placeEntity.getPlaceCoordinate())
				.placeGuide(placeEntity.getPlaceCaution())
				.build();
	
		return placeDTO;
	}
	
	default PlaceEntity DTOtoEntity(PlaceDTO placeDTO) {
		PlaceEntity placeEntity = PlaceEntity.builder()
				.placeNum(placeDTO.getPlaceNum())
				.placeName(placeDTO.getPlaceName())
				.placeOneLineIntroduction(placeDTO.getPlaceOneLineIntroduction())
				.placeIntroduction(placeDTO.getPlaceIntroduction())
				.placeBusinessHours(placeDTO.getPlaceBusinessHours())
				.placeHoliday(placeDTO.getPlaceHoliday())
				.placeRefundRegulations(placeDTO.getPlaceRefundRegulations())
				.placeAddress(placeDTO.getPlaceAddress())
				.placePhoneNumber(placeDTO.getPlacePhoneNumber())
				.placeCoordinate(placeDTO.getPlaceCoordinate())
				.placeGuide(placeDTO.getPlaceCaution())
				.build();
		
		return placeEntity;
		
	}
}
