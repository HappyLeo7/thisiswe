package com.thisiswe.home.place.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.thisiswe.home.place.dto.PlaceDTO;
import com.thisiswe.home.place.dto.PlacePageRequestDTO;
import com.thisiswe.home.place.dto.PlacePageResultDTO;
import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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
	public PlacePageResultDTO<PlaceDTO, PlaceEntity> getList(PlacePageRequestDTO placePageRequestDTO) {
		Pageable pageable = placePageRequestDTO.getPagealbe(Sort.by("placeNum").descending());

		// BooleanBuilder booleanBuilder = getSearch(requestDTO);

		Page<PlaceEntity> result = placeRepository.findAll(pageable);

		Function<PlaceEntity, PlaceDTO> fn = (entity -> entityToDTO(entity));
		return new PlacePageResultDTO<>(result, fn);
	}

	@Override
	public PlaceDTO read(Long placeNum) {
		Optional<PlaceEntity> result = placeRepository.findById(placeNum);
		return entityToDTO(result.get());
	}

	@Override
	public void modify(PlaceDTO placeDTO) {

	}

	@Override
	public void removeWithReplies(Long bno) {

	}

//	public BooleanBuilder getSearch(PageRequestDTO requestDTO) {
//		String type = requestDTO.getType();
//		BooleanBuilder booleanBuilder = new BooleanBuilder();
//		QEntityTest qEntityTest = QEntityTest.entityTest;
//		String keyword = requestDTO.getKeyword();
//		BooleanExpression expression = qEntityTest.tno.gt(0L);
//		booleanBuilder.and(expression);
//
//		if (type == null || type.trim().length() == 0) {
//			return booleanBuilder;
//		}
//
//		BooleanBuilder conditionBuilder = new BooleanBuilder();
//
//		if (type.contains("t")) {
//			conditionBuilder.or(qEntityTest.test_title.contains(keyword));
//		}
//		if (type.contains("c")) {
//			conditionBuilder.or(qEntityTest.test_content.contains(keyword));
//		}
//		booleanBuilder.and(conditionBuilder);
//
//		return booleanBuilder;
//	}

}
