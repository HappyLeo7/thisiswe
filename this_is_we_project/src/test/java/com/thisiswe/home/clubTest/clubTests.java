package com.thisiswe.home.clubTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.repository.ClubRepository;
import com.thisiswe.home.club.service.ClubService;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class clubTests {
	
	@Autowired
	private ClubRepository clubRepository;
	private ClubService clubService;
	
	
	//TODO [테스트] club 데이터 추가
	@Test
	public void clubRegister() {
		IntStream.rangeClosed(1, 20).forEach(i->{
		ClubEntity clubEntity = ClubEntity.builder()
				.clubPlace("지역"+i)
				.clubName("모임명")
				.clubContent("내용")
				.clubCategory("관심 카테고리")
				.clubLogo("로고사진")
				.clubLogoUuid("uuiduuid")
				.clubLogoUrl("url경로")
				.clubHeadCount(100L+i)
				.userId(UserEntity.builder().userId("user2").build())
				.build();
		clubRepository.save(clubEntity);
		});
	}
	
	//TODO [테스트] club  1개 불러오기
	@Test
	public void testGet() {
		Long clubNum=1L;
		System.out.println("1");
		
		//ClubEntity clubEntity = clubRepository.getById(clubNum);
		List<Object[]> clubEntityObject = clubRepository.getClubNum(clubNum);
		System.out.println("2");
		for(Object[] arr:clubEntityObject) {
		System.out.println("출력  ::"+
		Arrays.toString(arr));
		}
		
		System.out.println("3");
	}
	
	@Test
	public void testGetList() {


	}

}
