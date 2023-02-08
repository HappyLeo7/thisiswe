package com.thisiswe.home.club.board.service;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.dto.PageResultDTO;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.entity.Member;

//TODO [Service] 게시판
public interface BoardService {

	// TODO [Service] 게시판 - 등록(register)
	Long register(BoardDTO boardDTO);

	// TODO [Service] 게시판 - 읽기(get)
	BoardDTO get(Long boarNum);

	// TODO [Service] 게시판 - 페이지 목록(list)
	PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

	// TODO [Service] 공지사항 - DTO(WEB)에서 Entity(DB)로
	default Board noticeDTOToEntity(BoardDTO boardDTO) {
		
		Member member = Member.builder().us
		
		// 공지사항 번호, 카테고리, 제목, 내용, 조회수
		Board board = Board.builder()
						.boardNum(boardDTO.getBoardNum())
						.boardCategory(boardDTO.getBoardCategory())
						.boardTitle(boardDTO.getBoardTitle())
						.boardContent(boardDTO.getBoardContent())
						.userId(memberboardDTO.getUserId())
						.boardView(1)
						.build();

		return board;
	}

}
