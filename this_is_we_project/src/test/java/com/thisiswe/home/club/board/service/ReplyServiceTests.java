package com.thisiswe.home.club.board.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.club.board.reply.service.ReplyService;

@SpringBootTest
//TODO [ServiceTest] 게시글-댓글
public class ReplyServiceTests {
	
	@Autowired
	private ReplyService replyService;
	
	//TODO [ServiceTest] 게시글-댓글 : boardNum 불러오기
	@Test
	public void testGetList() {
		Long boardNum = 128L;
		List<ReplyDTO> replyDTOList = replyService.getList(boardNum);
		
		//TODO [ServiceTest] 게시글-댓글 : replyDTOList 출력
		System.out.println("[ReplyServiceTests][testGetList]=========================");
		System.out.println("[ReplyServiceTests][testGetList] replyDTOList ===> :: " + replyDTOList);
		
		replyDTOList.forEach(replyDTO -> System.out.println(replyDTO));
		System.out.println("/[ReplyServiceTests][testGetList]========================");
		
	}

}
