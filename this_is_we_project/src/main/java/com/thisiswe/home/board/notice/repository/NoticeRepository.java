package com.thisiswe.home.board.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import com.thisiswe.home.board.notice.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	
	//게시판 n번의 댓글 총 갯수를 의미
	/*
	 * @Query(" select n, w, count(r) " + " from Notice n left join n.writer w " +
	 * " left outer join Reply r on r.board = n " +
	 * " where n.noticeNum = :noticeNum ")
	 */
	Object getNoticeByNoticeNum(@Param("noticeNum") Long noticeNum);


	

}
