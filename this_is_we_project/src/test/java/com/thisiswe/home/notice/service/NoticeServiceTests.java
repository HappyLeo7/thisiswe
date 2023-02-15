package com.thisiswe.home.notice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.notice.dto.NoticeDTO;
import com.thisiswe.home.notice.dto.PageRequestDTO;
import com.thisiswe.home.notice.dto.PageResultDTO;

@SpringBootTest

//TODO [NoticeServiceTests] 공지사항
public class NoticeServiceTests {
	
	/*
	@Autowired
	private NoticeService noticeService;
	
	//TODO [NoticeServiceTests] 공지사항 - testList
	@Test
	public void testList() {
		
		PageRequestDTO pageRequestDTO = new PageRequestDTO();
		
		PageResultDTO<NoticeDTO, Object[]> result = noticeService.getList(pageRequestDTO);
		
		System.out.println("=========================================================");
		
		for(NoticeDTO noticeDTO : result.getDTOList()) {
			System.out.println("=============== noticeDTO ===============> : " + noticeDTO);
		}
		
		System.out.println("=========================================================");
	}
	*/
}
