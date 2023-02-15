package com.thisiswe.home.club.board.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.thisiswe.home.place.club.board.entity.Board;
import com.thisiswe.home.place.club.board.reply.entity.Reply;
import com.thisiswe.home.place.club.board.reply.repository.ReplyRepository;
import com.thisiswe.home.user.entity.UserEntity;

@SpringBootTest
@Transactional
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
			UserEntity member = UserEntity.builder().userId("user" + i).build();
			
			//TODO [ReplyRepositoryTest] 게시글-댓글 : boardNum 내 댓글 내용 생성하기
			Reply reply = Reply.builder()
							   .boardReplyContent("reply" + i)
							   .board(board)
							   .userId(member)							 
							   .build();
			
			replyRepository.save(reply);
		});
	}
	
	
	//TODO [ReplyRepositoryTest] 게시글-댓글 : 댓글과 댓글이 속한 게시판 읽어오기
	@Test
	public void testReadReply() {
		
		Optional<Reply> result = replyRepository.findById(31L);
		Reply reply = result.get();
		
		System.out.println("====================== reply 읽어오기 ======================");
		System.out.println(reply);
		System.out.println(reply.getBoard());
		System.out.println("====================== reply 읽어오기 ======================");
				
		}
	
	//TODO [ReplyRepositoryTest] 게시글-댓글 : 댓글 목록 읽어오기
	@Test
	public void testListByBoard() {
		
		System.out.println("=========================================================");
		
		List<Reply> replyList = replyRepository.getRepliesByBoardOrderByBoardReplyNum(
												Board.builder().boardNum(30L).build());
		
		replyList.forEach(reply -> System.out.println(reply)); 
		
		System.out.println("=========================================================");
		
	}
}
