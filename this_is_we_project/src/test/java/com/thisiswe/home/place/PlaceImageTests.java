package com.thisiswe.home.place;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceImageEntity;
import com.thisiswe.home.place.repository.PlaceImageRepository;

@SpringBootTest
@Ignore
public class PlaceImageTests {

	@Autowired
	private PlaceImageRepository placeImageRepository;

	// TODO [테스트] placeImage 데이터 추가
	@Test
	public void insertTest() {
		LongStream.rangeClosed(20, 80).forEach(i -> {
			PlaceImageEntity placeImageEntitiy = PlaceImageEntity.builder()
					.placeNum(PlaceEntity.builder().placeNum(i).build())
					.placeImageUuid(i + "-" + i + "-" + i)
					.placeImageName("이미지 이름" + i)
					.placeImageUrl(i + "/" + i + "/" + i)
					.build();
			placeImageRepository.save(placeImageEntitiy);
		});
	}

	// TODO [테스트] placeImage 데이터 조회
	@Test
	public void readTest() {
		Optional<PlaceImageEntity> result = placeImageRepository.findById(3L);
		System.out.println('a');
		System.out.println(result.get().getPlaceImageUrl());
		System.out.println('b');
		System.out.println(result.get().getPlaceNum().getPlaceNum());
		System.out.println('c');
	}

	// TODO [테스트] 장소에 등록된 사진 데이터 조회

	@Test 
	  public void readPlaceImagae() {
		List<PlaceImageEntity> result = placeImageRepository.findByPlaceNum(PlaceEntity.builder().placeNum(10L).build());
		System.out.println(1);
		System.out.println(result.get(0).getPlaceImageUrl());
		System.out.println(2);
	}
	 
	
	//TODO [테스트] placeImage 데이터 수정
	@Test
	public void updateTest() {
		LongStream.rangeClosed(10, 20).forEach(i->{
			PlaceImageEntity placeImageEntitiy = PlaceImageEntity.builder()
			.placeNum(PlaceEntity.builder().placeNum(i).build())
			.placeImageNum(i)
			.placeImageUuid(i + "-" + i + "-" + i)
			.placeImageName("(수정)이미지 이름" + i)
			.placeImageUrl(i + "/" + i + "/" + i)
			.build();
			placeImageRepository.save(placeImageEntitiy);
		});
	}

	// TODO [테스트] placeImage 데이터 삭제
	@Test
	public void deleteTest() {
		placeImageRepository.deleteById(3L);
	}
}
