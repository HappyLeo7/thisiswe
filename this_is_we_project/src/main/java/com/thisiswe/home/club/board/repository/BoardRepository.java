package com.thisiswe.home.club.board.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.repository.search.SearchBoardRepository;

//TODO [Repository] 게시판 - Query
public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository{
	
	//TODO [Repository] 게시판 - Query - 게시판 과 작성자 간 join
	@Query(" select b, u from Board b left join b.userId u where b.boardNum= :boardNum ")
	Object getBoardWithWriter(@Param("boardNum") Long boardNum);
	
	//TODO [Repository] 게시판 - Query - 게시판 내 댓글
	@Query(" select b, r from Board b left join Reply r on r.board = b where b.boardNum= :boardNum ")
	List<Object[]> getBoardWithReply(@Param("boardNum") Long boardNum);
		
	//TODO [Repository] 게시판 - Query - 게시판 과 작성자, 댓글 간 join
	@Query(value="select b, u, count(r) " + 
				 " from Board b " + 
				 " left join b.userId u " + 
				 " left join Reply r on r.board = b " + 
				 " group by b ", countQuery = "select count(b) from Board b")
	Page<Object[]> getBoardWithReplyCount(Pageable pageable);
		
	//TODO [Repository] 게시판 - Query - 게시판 n의 댓글 총 갯수 불러오기
	 @Query(" select b, u, count(r) " +
			" from Board b left join b.userId u " +
			" left outer join Reply r on r.board = b " +
			 " where b.boardNum = :boardNum ") 	 
	 Object getBoardByBoardNum(@Param("boardNum") Long boardNum);
	 
	//TODO [Repository] 게시판 - Query - 게시판 조회수 증가
	 @Modifying
	 @Transactional
	 @Query(" update Board b set b.boardView = b.boardView +1 where b.boardNum = :boardNum")
	 //Long boardView(Long boardNum);
	 int boardView(Long boardNum);
	 
	 Page<Board> findAllByUserId(String userId, Pageable pageable);
}
