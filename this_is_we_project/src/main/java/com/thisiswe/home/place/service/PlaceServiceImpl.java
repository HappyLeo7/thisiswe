package com.thisiswe.home.place.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.thisiswe.home.place.dto.PlaceDTO;
import com.thisiswe.home.place.repository.PlaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

	private final PlaceRepository placeRepository;

	@Override
	public Long register(PlaceDTO placeDTO) {
		placeRepository.save(DTOtoEntity(placeDTO));
		return placeDTO.getPlaceNum();
	}

	@Override
	public List<PlaceDTO> getList() {
		List<PlaceDTO> result = placeRepository.findAll().stream().map(i -> entityToDTO(i))
				.collect(Collectors.toList());
		return result;
	}

	@Override
	public void modify(PlaceDTO placeDTO) {

	}

	@Override
	public void removeWithReplies(Long bno) {

	}

}
