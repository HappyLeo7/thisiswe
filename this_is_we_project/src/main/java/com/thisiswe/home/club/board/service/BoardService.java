package com.thisiswe.home.club.board.service;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.dto.PageResultDTO;
import com.thisiswe.home.club.board.entity.Board;
import org.springframework.stereotype.Service;

import com.thisiswe.home.user.entity.UserEntity;

@Service
//TODO [Service] 게시판
public interface BoardService {
	
	// TODO [Service] 게시판 - 등록(register)
	Long register(BoardDTO boardDTO);

	// TODO [Service] 게시판 - 읽기(get)
	BoardDTO get(Long boardNum);

	// TODO [Service] 게시판 - 페이지 목록(list)
	PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

	// TODO [Service] 게시판 - 수정(modify)
	void modify(BoardDTO boardDTO);
	
	// TODO [Service] 게시판 - 게시판 1개를 삭제(remove)하면 댓글도 함께 사라지도록
	void removeWithReplies(Long boardNum);
	
	// TODO [Service] 게시판 - 조회수 증가(중복 제외)
	Long countView(Long boardNum, BoardDTO boardDTO);
	
	// TODO [Service] 게시판 - DTO(WEB)에서 Entity(DB)로
	default Board boardDTOToEntity(BoardDTO boardDTO) {
				
		UserEntity member = UserEntity.builder().userId(boardDTO.getUserId()).build();
		
		// 게시판 번호, 카테고리, 제목, 내용, 조회수
		Board board = Board.builder()
						.boardNum(boardDTO.getBoardNum())
						.boardCategory(boardDTO.getBoardCategory())
						.boardTitle(boardDTO.getBoardTitle())
						.boardContent(boardDTO.getBoardContent())
						.userId(member)
						.boardView(boardDTO.getBoardView()+1)
						.build();

		return board;
	}
	
	//TODO [Service] 게시판 - Entity(DB)에서 DTO(WEB)로
		default BoardDTO entityToBoardDTO(Board board, UserEntity userEntity, Long replyCount) {
			
			//게시판 번호, 카테고리, 제목, 내용, 유저아이디, 수정일, 조회수, 댓글수
			BoardDTO boardDTO = BoardDTO.builder()
								.boardNum(board.getBoardNum())
								.boardCategory(board.getBoardCategory())
								.boardTitle(board.getBoardTitle())
								.boardContent(board.getBoardContent())
								.userId(userEntity.getUserId())
								.regDate(board.getRegDate())
								.updateDate(board.getUpdateDate())
								.boardView(board.getBoardView())
								.replyCount(replyCount.intValue())		//replyCount는 Long보다는 int 타입을 사용하기!
								.build();
													
			return boardDTO;
		}

}
