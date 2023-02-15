package com.thisiswe.home.place.club.board.reply.service;

import java.util.List;

import com.thisiswe.home.place.club.board.entity.Board;
import com.thisiswe.home.place.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.place.club.board.reply.entity.Reply;
import com.thisiswe.home.user.entity.UserEntity;

//TODO [Service] 게시판-댓글
public interface ReplyService {

	//TODO [Service] 게시글-댓글 - 등록(register)
	Long register(ReplyDTO replyDTO);
	
	//TODO [Service] 게시글-댓글 - 게시판 번호 읽기(get)
	List<ReplyDTO> getList(Long board_num);

	//TODO [Service] 게시글-댓글 - 수정(modify)
	void modify(ReplyDTO replyDTO);
	
	//TODO [Service] 게시글-댓글 - 삭제(remove)
	void remove(Long boardReplyNum);
	
	//TODO [Service] 게시글-댓글 - DTO(WEB)에서 Entity(DB)로
	default Reply replyDTOToEntity(ReplyDTO replyDTO) {

		Board board = Board.builder().boardNum(replyDTO.getBoardNum()).build();
		UserEntity member = UserEntity.builder().userId(replyDTO.getUserId()).build();
		
		// 게시글-댓글 번호, 내용, userId, 게시판
		Reply reply = Reply.builder()
						   .boardReplyNum(replyDTO.getBoardReplyNum())
						   .boardReplyContent(replyDTO.getBoardReplyContent())
						   .userId(member)
						   .board(board)
						   .build();
		return reply;
	}
	
	//TODO [Service] 게시글-댓글 - Entity(DB)에서 DTO(WEB)로
	default ReplyDTO entityToReplyDTO(Reply reply) {
					
		ReplyDTO replyDTO = ReplyDTO.builder()
									.boardReplyNum(reply.getBoardReplyNum())
									.boardReplyContent(reply.getBoardReplyContent())
									.userId(reply.toString())
									.regDate(reply.getRegDate())
									.updateDate(reply.getUpdateDate())
									.build();
		return replyDTO;
	}
}
