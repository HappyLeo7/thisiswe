package com.thisiswe.home.place.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.thisiswe.home.place.dto.PlaceDTO;
import com.thisiswe.home.place.dto.PlacePageRequestDTO;
import com.thisiswe.home.place.dto.PlacePageResultDTO;
import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceImageEntitiy;
import com.thisiswe.home.place.repository.PlaceImageRepository;
import com.thisiswe.home.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

	private final PlaceRepository placeRepository;
	private final PlaceImageRepository placeImageRepository;

	@Override
	public Long register(PlaceDTO placeDTO) {
		log.info("PlaceServiceImpl클래스 register 메소드");
		Map<String, Object> entityMap = DTOtoEntity(placeDTO);
		PlaceEntity placeEntity  = (PlaceEntity) entityMap.get("place");
		List<PlaceImageEntitiy>placeImageList = (List<PlaceImageEntitiy>) entityMap.get("placeImgList");

		placeRepository.save(placeEntity);
		
		placeImageList.forEach(placeImage->{
			placeImageRepository.save(placeImage);
		});
		
		return placeDTO.getPlaceNum();

	}

	@Override
	public PlacePageResultDTO<PlaceDTO, Object[]> getList(PlacePageRequestDTO placePageRequestDTO) {
		/*
		 * log.info("PlaceServiceImpl클래스 getList 메소드");
		 * 
		 * Pageable pageable =
		 * placePageRequestDTO.getPagealbe(Sort.by("placeNum").descending());
		 * 
		 * // BooleanBuilder booleanBuilder = getSearch(requestDTO);
		 * 
		 * Page<Object[]> result = placeRepository.getListPage(pageable);
		 * 
		 * result.getContent().forEach(arr->{ log.info(Arrays.toString(arr)); });
		 * 
		 * Function<Object[], PlaceDTO> fn = (arr ->
		 * entitiesToDTO((PlaceEntity)arr[0],(List<PlaceImageEntitiy>)(Arrays.asList((
		 * PlaceImageEntitiy)arr[1])),(Double)arr[2],(Long)arr[3])); return new
		 * PlacePageResultDTO<>(result, fn);
		 */
		return null;
	}

	@Override
	public PlaceDTO getPlace(Long placeNum) {
		/*
		 * List<Object[]> result = placeRepository.getPlaceWithAll(placeNum);
		 * 
		 * PlaceEntity placeEntity = (PlaceEntity) result.get(0)[0];
		 * 
		 * List<PlaceImageEntitiy> placeImageList = new ArrayList<>();
		 * 
		 * result.forEach(arr->{ PlaceImageEntitiy placeImageEntitiy =
		 * (PlaceImageEntitiy) arr[1]; placeImageList.add(placeImageEntitiy); });
		 * 
		 * Double avg = (Double) result.get(0)[2]; Long reviewCount = (Long)
		 * result.get(0)[3]; return entitiesToDTO(placeEntity, placeImageList, avg,
		 * reviewCount);
		 */
		return null;
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
