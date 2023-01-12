package com.keduit.mapper;

import java.util.List;

import com.keduit.domain.BoardVO;
import com.keduit.domain.Criteria;

public interface BoardMapper2 {
	//@Select("select * from tbl_board order by bno DESC")
	public List<BoardVO> getList();
	
	//페이지 받아오기
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public int insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public Long delete(Long bno);

	public int update(BoardVO board);

	
	
	
	
	
	/*
	 * @Select("select sysdate from dual") public String getTime();
	 */
	
	
	
}
