package com.thisiswe.home.place;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.repository.PlaceRepository;
import com.thisiswe.home.user.entity.UserEntity;

@SpringBootTest
public class PlaceTests {

	@Autowired
	private PlaceRepository placeRepository;

	// TODO [테스트] place 데이터 추가
	@Test
	public void insertTest() {
		LongStream.rangeClosed(1, 100).forEach(i -> {

			PlaceEntity placeEntity = PlaceEntity.builder().userId(UserEntity.builder().userId("user" + i).build())
					.placeName("유저" + i).placeOneLineIntroduction("한줄 소개" + i).placeIntroduction("소개글" + i)
					.placeBusinessHours("12시~24시 영업").placeHoliday("공휴일 휴무").placeRefundRegulations("환불 규정은 ~입니다")
					.placeAddress("관악로" + i + "길").placePhoneNumber("010-1111-1111")
					.placeCoordinate(i + "." + i + "." + i).placeGuide("찾아오는 길은 ~~입니다").placeCaution("사용 시 ~ 는 주의해주세요.")
					.build();
			placeRepository.save(placeEntity);
		});
	}

	// TODO [테스트] place 데이터 조회
	@Test
	public void readTest() {
		System.out.println("1");
		System.out.println("------------readTest------------");
		System.out.println("2");
		System.out.println(placeRepository.findById(8L).get().getUserId());
		System.out.println("3");
		Optional<PlaceEntity> result = placeRepository.findById(50L);
		System.out.println("4");
		System.out.println(result.get().getPlaceCaution());
		System.out.println("5");
		PlaceEntity result1 = result.get();
		System.out.println(result1);
		System.out.println("6");
		System.out.println("여기 : " + result.get().getPlaceName());
		System.out.println("7");
	}

	// TODO [테스트] 등록자가 등록한 place 데이터 조회
	@Test
	public void readRegistedPlaceTest() {
		System.out.println(1);
		List<PlaceEntity> result = placeRepository.findByUserId(UserEntity.builder().userId("user1").build());
		System.out.println(2);
		System.out.println(result.get(0).getPlaceAddress());
		System.out.println(3);
	}

	// TODO [테스트] place 데이터 삭제
	@Test
	public void deleteTest() {
		placeRepository.deleteById(97L);
	}

	// TODO [테스트] place 데이터 수정
	@Test
	public void updateTest() {
		LongStream.rangeClosed(30, 31).forEach(i -> {

			PlaceEntity placeEntity = PlaceEntity.builder().placeNum(i)
					.userId(UserEntity.builder().userId("user" + i).build()).placeName("(수정)유저" + i)
					.placeOneLineIntroduction("(수정)한줄 소개" + i).placeIntroduction("(수정)소개글" + i)
					.placeBusinessHours("(수정)12시~24시 영업").placeHoliday("(수정)공휴일 휴무")
					.placeRefundRegulations("(수정)환불 규정은 ~입니다").placeAddress("(수정)관악로" + i + "길")
					.placePhoneNumber("(수정)010-1111-1111").placeCoordinate("(수정)" + i + "." + i + "." + i)
					.placeGuide("(수정)찾아오는 길은 ~~입니다").placeCaution("(수정)사용 시 ~ 는 주의해주세요.").build();
			placeRepository.save(placeEntity);
		});
	}

}
