package com.thisiswe.home.club.board.reply.repository;

import java.util.List;

import com.thisiswe.home.club.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.thisiswe.home.club.board.reply.entity.Reply;

//TODO [ReplyRepository] 게시글-댓글
public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	//TODO [ReplyRepository] 게시글-댓글 : 댓글 부분
	@Modifying
	@Query("delete from Reply r where r.board.boardNum = :boardNum")
	//TODO [ReplyRepository] 게시글-댓글 : boardNum이 같은 것만 지우기.
	void deleteByBoardNum(Long boardNum);
	
	//TODO [ReplyRepository] 게시글-댓글 : 게시물로 댓글 가져오기
	List<Reply> getRepliesByBoardOrderByBoardReplyNum(Board board);
	
}
