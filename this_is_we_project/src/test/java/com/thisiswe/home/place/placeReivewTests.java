package com.thisiswe.home.place;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.entity.PlaceReviewEntity;
import com.thisiswe.home.place.repository.PlaceReviewRepository;
import com.thisiswe.home.user.entity.UserEntity;

@SpringBootTest
public class placeReivewTests {

	@Autowired
	private PlaceReviewRepository placeReviewRepository;
	
	@Test
	public void insertTest(){
		LongStream.rangeClosed(3, 50).forEach(i->{
			
			PlaceReviewEntity placeReviewEntity = PlaceReviewEntity
					.builder()
					.placeNum(PlaceEntity.builder().placeNum(i).userId(UserEntity.builder().userId("user" + i).build()).build())
					.userId(UserEntity.builder().userId("user" + i).build())
					.placeReviewContent("내용" + i)
					.placeReviewRate((int) (Math.random() * 6))
					.build();
			
			
			placeReviewRepository.save(placeReviewEntity);
		});
		
		
	}
	
}
