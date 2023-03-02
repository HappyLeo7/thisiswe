package com.thisiswe.home.club.board.service;

import java.util.List;

import com.thisiswe.home.club.board.reply.dto.ReplyRequestDTO;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.board.reply.service.ReplyServiceImpl;
import com.thisiswe.home.user.entity.UserEntity;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.club.board.reply.service.ReplyService;
import org.springframework.data.domain.Page;

@SpringBootTest
//@Ignore
//TODO [ServiceTest] 게시글-댓글
public class ReplyServiceTests {
	
	@Autowired
	private ReplyService replyService;
	@Autowired
	private ReplyServiceImpl replyServiceimpl;
	
	//TODO [ServiceTest] 게시글-댓글 : boardNum 불러오기
	@Test
	public void testGetList() {
		Long boardNum = 128L;
		Page<Reply> replyDTOList = replyService.getList(boardNum , 10, 1);
		
		//TODO [ServiceTest] 게시글-댓글 : replyDTOList 출력
		System.out.println("[ReplyServiceTests][testGetList]=========================");
		System.out.println("[ReplyServiceTests][testGetList] replyDTOList ===> :: " + replyDTOList);
		
		replyDTOList.forEach(replyDTO -> System.out.println(replyDTO));
		System.out.println("/[ReplyServiceTests][testGetList]========================");
		
	}

	//reply등록
	@Test
	public void testResistReply(){
		ReplyRequestDTO replyRequestDTO = ReplyRequestDTO.builder()
				.boardReplyContent("QQNDIOVLD")
				.boardNum(1L)
				.userId("normal")
				.build();
		System.out.println("start");
		replyServiceimpl.register(replyRequestDTO);
	}

}
