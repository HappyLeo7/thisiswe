package com.thisiswe.home.place.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisiswe.home.place.dto.PlaceReviewDTO;
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
	public List<PlaceReviewDTO> getList(Long placeNum) {
		List<PlaceReviewEntity> result = placeReviewRepository.findByPlaceNum(placeRepository.findById(placeNum).get());
		return result.stream().map(i-> entityToDTO(i)).collect(Collectors.toList());
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
