package com.thisiswe.home.club.board.service;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.dto.PageResultDTO;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.user.entity.UserEntity;

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
	
	// TODO [Service] 게시판 - 삭제(remove)
	void remove(Long boardNum);
	
	// TODO [Service] 공지사항 - DTO(WEB)에서 Entity(DB)로
	default Board boardDTOToEntity(BoardDTO boardDTO) {
				
		UserEntity member = UserEntity.builder().userId(boardDTO.getUserId()).build();
		
		// 공지사항 번호, 카테고리, 제목, 내용, 조회수
		Board board = Board.builder()
						.boardNum(boardDTO.getBoardNum())
						.boardCategory(boardDTO.getBoardCategory())
						.boardTitle(boardDTO.getBoardTitle())
						.boardContent(boardDTO.getBoardContent())
						.userId(member)
						.boardView(boardDTO.getBoardView())
						.build();

		return board;
	}
	
	//TODO [Service] 공지사항 - Entity(DB)에서 DTO(WEB)로
		default BoardDTO entityToBoardDTO(Board board, UserEntity userEntity, Long replyCount) {
			
			//공지사항 번호, 카테고리, 제목, 내용, 유저아이디, 수정일, 조회수, 댓글수
			BoardDTO boardDTO = BoardDTO.builder()
								.boardNum(board.getBoardNum())
								.boardCategory(board.getBoardCategory())
								.boardTitle(board.getBoardTitle())
								.boardContent(board.getBoardContent())
								.userId(userEntity.getUserId())
								.updateDate(board.getUpdateDate())
								.boardView(board.getBoardView())
								.replyCount(board.getReplyCount())
								.build();
													
			return boardDTO;
		}
	

}
