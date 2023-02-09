package com.thisiswe.home.place;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceTagEntity;
import com.thisiswe.home.place.repository.PlaceTagRepositroy;

@SpringBootTest
public class PlaceTagTest {

	@Autowired
	private PlaceTagRepositroy placeTagRepositroy;

	// TODO [테스트] placeTag 데이터 추가
	@Test
	public void insertTest() {
		LongStream.rangeClosed(20, 80).forEach(i -> {
			PlaceTagEntity placeTagEntity = PlaceTagEntity.builder()
					.placeNum(PlaceEntity.builder().placeNum(i).build())
					.placeTagContent("태그" + i)
					.build();
			placeTagRepositroy.save(placeTagEntity);
		});
	}

}
