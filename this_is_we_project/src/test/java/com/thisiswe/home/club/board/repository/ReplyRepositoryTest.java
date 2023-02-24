package com.thisiswe.home.club.board.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.board.reply.repository.ReplyRepository;
import com.thisiswe.home.user.entity.UserEntity;

@SpringBootTest
@Transactional
@Ignore
//TODO [ReplyRepositoryTest] 게시글-댓글
public class ReplyRepositoryTest {
	
	@Autowired
	private ReplyRepository replyRepository;
		
	@Test
	//TODO [ReplyRepositoryTest] 게시글-댓글 : boardNum 댓글 생성하기
	public void insertReply() {
		
		System.out.println("[ReplyRepositoryTest][insertReply]=======================");
		LongStream.range(1, 50).forEach(i -> {
			
			UserEntity member = UserEntity.builder().userId("user" + i).build();
			
			//TODO [ReplyRepositoryTest] 게시글-댓글 : boardNum 내 댓글 내용 생성하기
			Reply reply = Reply.builder()
							   .boardNum(Board.builder().boardNum(i).userId(UserEntity.builder().userId("user" + i).build()).build())
							   .boardReplyContent("reply" + i)
							   .userId(member)	
							   .build();
		
		/*LongStream.rangeClosed(1, 50).forEach(i -> {
				
			Reply reply = Reply.builder()
						  	.boardNum(Board.builder().boardNum(i).userId(UserEntity.builder().userId("user" + i).build()).build())
						  	.userId(UserEntity.builder().userId("user" + i).build())
						  	.boardReplyContent("content" + i)						  	
							.build();
		 */
			replyRepository.save(reply);
			
			System.out.println("/[ReplyRepositoryTest][insertReply]======================");
		});
	}
	
	
	//TODO [ReplyRepositoryTest] 게시글-댓글 : 댓글과 댓글이 속한 게시판 읽어오기
	@Test
	public void testReadReply() {
		
		Optional<Reply> result = replyRepository.findById(31L);
		Reply reply = result.get();
		
		System.out.println("[ReplyRepositoryTest][testReadReply]=====================");
		System.out.println(reply);
		System.out.println(reply.getBoard());
		System.out.println("/[ReplyRepositoryTest][testReadReply]====================");
				
		}
	
	//TODO [ReplyRepositoryTest] 게시글-댓글 : 댓글 목록 읽어오기
	@Test
	public void testListByBoard() {
		
		System.out.println("[ReplyRepositoryTest][testListByBoard]===================");
		/* List<Reply> replyList = replyRepository.getRepliesByBoardOrderByBoardReplyNum( */
		List<Reply> replyList = replyRepository.findByBoardNum(Board.builder().boardNum(41L).build());
		
		System.out.println("[ReplyRepositoryTest][testListByBoard] replyList ===> " + replyList);
		replyList.forEach(reply -> System.out.println(reply)); 
		
		System.out.println("/[ReplyRepositoryTest][testListByBoard]==================");
		
	}
}
