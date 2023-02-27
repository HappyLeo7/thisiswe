package com.thisiswe.home.place.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thisiswe.home.place.dto.PlacePageRequestDTO;
import com.thisiswe.home.place.dto.PlaceReviewDTO;
import com.thisiswe.home.place.dto.PlaceReviewPageRequestDTO;
import com.thisiswe.home.place.dto.PlaceReviewPageResultDTO;
import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceReviewEntity;
import com.thisiswe.home.place.repository.PlaceRepository;
import com.thisiswe.home.place.repository.PlaceReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceReviewServiceImpl implements PlaceReviewService {

	private final PlaceReviewRepository placeReviewRepository;
	private final PlaceRepository placeRepository;

	@Override
	public Long register(PlaceReviewDTO placeReviewDTO) {
		PlaceReviewEntity result = dtoToEntity(placeReviewDTO);
		placeReviewRepository.save(result);
		return result.getPlaceReviewNum();
	}

	@Override
	public PlaceReviewPageResultDTO<PlaceReviewDTO, PlaceReviewEntity> getList(PlaceReviewPageRequestDTO placeReviewPageRequestDTO) {
		Pageable pageable = placeReviewPageRequestDTO.getPagealbe(Sort.by("placeReviewNum").descending());
		
		Page<PlaceReviewEntity> result = placeReviewRepository.findByPlaceNum(PlaceEntity.builder().placeNum(placeReviewPageRequestDTO.getPlaceNum()).build(), pageable);
		
		
		Function<PlaceReviewEntity, PlaceReviewDTO>fn = (entity-> entityToDTO(entity));
		return new PlaceReviewPageResultDTO<>(result, fn);
	}

	@Override
	public void modify(PlaceReviewDTO placeReviewDTO) {
		placeReviewRepository.save(dtoToEntity(placeReviewDTO));
	}

	@Override
	public void remove(Long placeReviewNum) {
		placeReviewRepository.deleteById(placeReviewNum);
	}
	
	
	
}
