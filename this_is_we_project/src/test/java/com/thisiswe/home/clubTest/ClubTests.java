package com.thisiswe.home.clubTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.member.ClubMemberEntity;
import com.thisiswe.home.club.member.ClubMemberRepository;
import com.thisiswe.home.club.repository.ClubRepository;
import com.thisiswe.home.club.service.ClubService;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Ignore
public class ClubTests {
	
	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private ClubService clubService;
	
	@Autowired
	private ClubMemberRepository clubMemberRepository;
	
	
	//TODO [테스트] club 데이터 추가
	@Test
	public void clubRegister() {
		IntStream.rangeClosed(1, 10).forEach(i->{
		ClubEntity clubEntity = ClubEntity.builder()
				.clubPlace("지역"+i)
				.clubName("모임명")
				.clubContent("내용")
				.clubCategory("운동")
				.clubLogo("로고사진")
				.clubLogoUuid("uuiduuid")
				.clubLogoUrl("url경로")
				.clubHeadCount(100L+i)
				.userId(UserEntity.builder().userId("leo").build())
				.build();
		clubRepository.save(clubEntity);
		});
	}
	
	//TODO [테스트] club  1개 불러오기
	@Test
	public void testGet() {
		Long clubNum=2L;
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
	
	//수정하기
	@Test
	public void testModfiy(MultipartFile file) throws Exception {
		//클럽 DTO에서 수정을 할거야
		System.out.println("");
		ClubDTO clubDTO = ClubDTO.builder()
				.clubNum(2L)
				.clubPlace("보라매")
				//.userId("user1")
				//.userNickname("CuteDragon1")
				.clubName("thisiswe")
				.clubContent("경원 나영 동완 수찬 세원")
				.clubCategory("반려동물")
				.clubLogo("이미지이름")
				.clubLogoUuid("이미지uuid")
				.clubLogoUrl("이미지Url")
				.clubHeadCount(50L)
				
				.build();
		System.out.println("수정값 : "+clubDTO);
		
		System.out.println("");
		clubService.modify(clubDTO,file);
		System.out.println("modify 실행됨");
		
	}

	//TODO [테스트] 모임 삭제
	@Test
	public void testClubRemove() {
		
		
		//clubRepository.clubRemove(3L);
		clubRepository.deleteById(3L);
	}
	
	
	
	//TODO [테스트] 모임에 회원 가입 하는 테스트
	@Test
	public void testMemberRegister() {
		//IntStream.rangeClosed(1, 10).forEach(i->{
		ClubMemberEntity clubMemberEntity=ClubMemberEntity.builder()
				.userId(UserEntity.builder().userId("leo").build())
				.clubNum(3L)
				.clubMemberRole(0L)
				.build();
		
		System.out.println("모임 맴버 추가 : "+clubMemberEntity);
		clubMemberRepository.save(clubMemberEntity);
		//});
	}

	
	
	@Test
	public void testPageList() {
		
		
	}
	
	@Test
	public void test() {
	}
	
}