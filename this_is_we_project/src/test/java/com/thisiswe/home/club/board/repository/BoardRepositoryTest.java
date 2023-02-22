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
import javax.transaction.Transactional;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.user.entity.UserEntity;

@SpringBootTest
//TODO [RepositoryTest] 게시판 - Query Test
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;
	
	//TODO [RepositoryTest] 게시판 - Query 만들기
	@Test
	public void insertBoards() {
		
		IntStream.rangeClosed(1, 15).forEach(i -> {
			
//			UserEntity member = UserEntity.builder().userId("user" + i).build();
			UserEntity member = UserEntity.builder().userId("leo").build();
					
			Board board = Board.builder()
							.boardCategory("모임 추가")
							.boardTitle("oo클래스 오픈했어요!")
							.boardContent("oo클래스 장소는 oo역 2번 출구 바로 앞 공방으로 오세요! pm 14:00. 많관부")
							.userId(member)
							.boardView(5L)
							.clubNum(ClubEntity.builder().clubNum(3L).build())
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
		System.out.println("================== BoardRepositoryTest ==================");
		System.out.println("===================== Board 게시판 확인 =====================");
		System.out.println(board);
		System.out.println("================= Board 게시판 UserID 확인 =================");
		System.out.println(board.getUserId());	
		System.out.println("================== BoardRepositoryTest ==================");
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
	
	//TODO [RepositoryTest] 게시판 - Query - 게시판 과 작성자 간 join
	@Test
	public void testReadBoardWithWriter() {
		
		Object result = boardRepository.getBoardWithWriter(45L);
		Object[] arr = (Object[]) result;
		
		System.out.println("=========================================================");
		System.out.println(Arrays.toString(arr));
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
	
	//TODO [RepositoryTest] 게시판 - Query - 검색 제목 "ex) 모임" 입력 시, 총 검색 갯수
	@Transactional
	@Test
	public void testSearchPage() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("boardNum").descending());
		
		System.out.println("================== BoardRepositoryTest ==================");
		System.out.println("================== pageable ==================" + pageable);
		System.out.println("================== BoardRepositoryTest ==================");
		
		Page<Object[]> result = boardRepository.searchPage("t", "모임", pageable);
		
		System.out.println("================== BoardRepositoryTest ==================");
		System.out.println("==================== result ====================" + result);
		System.out.println("================== BoardRepositoryTest ==================");
		
	}
		
	@Transactional
	@Test
	public void testSearchPageSort() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("boardNum")
				.descending().and(Sort.by("boardTitle").ascending()));
		
		System.out.println("================== BoardRepositoryTest ==================");
		System.out.println(pageable);
		System.out.println("================== BoardRepositoryTest ==================");
		
		Page<Object[]> result = boardRepository.searchPage("t", "모임", pageable);
		
		System.out.println("================== BoardRepositoryTest ==================");
		System.out.println(result);
		System.out.println("================== BoardRepositoryTest ==================");
	}
}
