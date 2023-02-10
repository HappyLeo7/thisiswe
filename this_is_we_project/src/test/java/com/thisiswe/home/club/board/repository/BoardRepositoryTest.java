package com.thisiswe.home.club.board.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.user.entity.UserEntity;

@SpringBootTest
//TODO [RepositoryTest] 게시판 - Query Test
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;
	
	//TODO [RepositoryTest] 게시판 - Query 만들기
	@Test
	public void insertBoards() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			UserEntity member = UserEntity.builder().userId("user" + i).build();
			
			Board board = Board.builder()
							.boardCategory("모임 변경" + i)
							.boardTitle("동아리 변경 관련 문의" + i)
							.boardContent("oo동아리 2명 더 필요해요" + i)
							.userId(member)
							.build();							
			
			boardRepository.save(board);
		});
	}
	
	//TODO [RepositoryTest] 게시판 - Query - 게시판 일어오기
	@Transactional
	@Test
	public void testReadBoard() {
		
		Optional<Board> result = boardRepository.findById(23L);
		
		Board board = result.get();
		
		System.out.println("=========================================================");
		System.out.println("================ Board 게시판 확인 ================> " + board);
		System.out.println("====== Board 게시판 UserID 확인 ======> " + board.getUserId());		
		System.out.println("=========================================================");
		
	}
	
	//TODO [RepositoryTest] 게시판 - Query - 게시판 내 댓글
	@Test
	public void testGetBoardWithReply() {
		
		List<Object[]> result = boardRepository.getBoardWithReply(13L);
		System.out.println("=========================================================");
		
		for(Object[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println("=========================================================");
	}
	
	//TODO [RepositoryTest] 게시판 - Query - 게시판 n번 읽어오기
	@Transactional
	@Test
	public void testReadOne() {
		
		Object result = boardRepository.getBoardByBoardNum(7L);
		Object[] arr = (Object[]) result;
		
		System.out.println("=========================================================");
		System.out.println(Arrays.toString(arr));
		System.out.println("=========================================================");		
	}

	//TODO [RepositoryTest] 게시판 - Query - 댓글 갯수
	@Transactional
	@Test
	public void testWithReplyCount() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("boardNum").descending());
		
		Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);
		System.out.println("=========================================================");
		
		result.get().forEach(row -> {
			Object[] arr = row;
			
			System.out.println(Arrays.toString(arr));
		});
		
		System.out.println("=========================================================");
	}
	
	//TODO [RepositoryTest] 게시판 - Query - 검색 제목 "모임" 입력 시, 총 검색 갯수
	@Transactional
	@Test
	public void testSearchPage() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("boardNum").descending());
		Page<Object[]> result = boardRepository.searchPage("t", "모임", pageable);
	}
	
	/*
	@Transactional
	@Test
	public void testSearchPageSort() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("boardNum").descending()
												.and(Sort.by("title").ascending()));
		Page<Object[]> result = boardRepository.searchPage("t", "2", pageable);
	}
	*/
}
