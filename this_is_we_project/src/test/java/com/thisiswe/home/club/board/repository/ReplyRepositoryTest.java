package com.thisiswe.home.club.board.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.board.reply.repository.ReplyRepository;
import com.thisiswe.home.user.entity.UserEntity;

@SpringBootTest
//TODO [ReplyRepositoryTest] 게시글-댓글
public class ReplyRepositoryTest {
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Test
	//TODO [ReplyRepositoryTest] 게시글-댓글 : boardNum 댓글 생성하기
	public void insertReply() {
		IntStream.range(1, 30).forEach(i -> {
			long boardNum = (long)(Math.random() * 10) + 1; 
			Board board = Board.builder().boardNum(boardNum).build();
			
			UserEntity member = UserEntity.builder().userId(toString()).build();
			
			Reply reply = Reply.builder()
							   .boardReplyContent("reply" + i)
							   .board(board)
					/* .userId("user" + i) */
							   .build();
			
			replyRepository.save(reply);
		});
	}
	

}
