package com.thisiswe.home.place.service;

import java.util.List;

import com.thisiswe.home.place.dto.PlaceReviewDTO;
import com.thisiswe.home.place.dto.PlaceReviewPageRequestDTO;
import com.thisiswe.home.place.dto.PlaceReviewPageResultDTO;
import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceReviewEntity;
import com.thisiswe.home.user.entity.UserEntity;

public interface PlaceReviewService {

	Long register(PlaceReviewDTO placeReviewDTO);

	PlaceReviewPageResultDTO<PlaceReviewDTO,PlaceReviewEntity> getList(PlaceReviewPageRequestDTO placeReviewPageRequestDTO);

	void modify(PlaceReviewDTO placeReviewDTO);

	void remove(Long placeReviewNum);

	default PlaceReviewEntity dtoToEntity(PlaceReviewDTO placeReviewDTO) {

		PlaceEntity placeEntity = PlaceEntity.builder().placeNum(placeReviewDTO.getPlaceNum()).build();
		UserEntity userEntity = UserEntity.builder().userId(placeReviewDTO.getUserId()).build();

		PlaceReviewEntity placeReviewEntity = PlaceReviewEntity
				.builder()
				.placeReviewNum(placeReviewDTO.getPlaceReviewNum())
				.placeNum(placeEntity)
				.userId(userEntity)
				.placeReviewContent(placeReviewDTO.getPlaceReviewContent())
				.placeReviewRate(placeReviewDTO.getPlaceReviewRate())
				.build();
		return placeReviewEntity;
	}

	default PlaceReviewDTO entityToDTO(PlaceReviewEntity placeReviewEntity) {
		
		PlaceReviewDTO replyDTO = PlaceReviewDTO
				.builder()
				.placeReviewNum(placeReviewEntity.getPlaceReviewNum())
				.placeNum(placeReviewEntity.getPlaceNum().getPlaceNum())
				.userId(placeReviewEntity.getUserId().getUserId())
				.writer(placeReviewEntity.getUserId().getUserNickname())
				.placeReviewContent(placeReviewEntity.getPlaceReviewContent())
				.placeReviewRate(placeReviewEntity.getPlaceReviewRate())
				.regDate(placeReviewEntity.getRegDate())
				.updateDate(placeReviewEntity.getUpdateDate())
				.build();
		return replyDTO;

	}

}
