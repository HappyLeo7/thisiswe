package com.thisiswe.home.clubTest;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.club.photo.entity.PhotoEntity;
import com.thisiswe.home.club.photo.repository.PhotoRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class PhotoTests {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	//TODO [테스트] 사진첩 리스트 불러오기
	@Test
	public void photoList() {
		
		Long clubNum = 3L;
		List<Object[]> list=photoRepository.getPhotoList(3L);
		//System.out.println("사진첩 리스트 : "+ list);
		log.info("사진첩 list : " +list);
		
		for(Object[] arr : list) {
			log.info("사진첩 list : ");
			PhotoEntity a = (PhotoEntity) arr[0];
			log.info("이미지이름 : "+a.getPhotoImage());
			log.info("이미지이름 : "+a.getPhotoNum());
			log.info("이미지이름 : "+a.getUserId().getUserId());
			log.info("사진첩 list [0]"+(PhotoEntity) arr[0]);
			//log.info("사진첩 list [1]"+arr[1]); +Arrays.toString(arr)
			//log.info("사진첩 list [0]"+arr[0]);
		}
		
	}

}
