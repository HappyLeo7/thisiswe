package com.thisiswe.home.place.club.board.reply.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.thisiswe.home.place.club.board.entity.Board;
import com.thisiswe.home.enetity.DateEntity;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude={"userId", "board"})

//TODO [Entity]게시판 Reply table 컬럼(유저ID, 내용)
public class Reply extends DateEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_reply_num")
	private Long boardReplyNum;				 	// 게시판_댓글 번호
	
	@Column(length=100, name="board_reply_content")
	private String boardReplyContent;			// 게시판_댓글 내용

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserEntity userId;					// 게시판_댓글 유저ID
	
	//게시판 작성자와 회원 닉네임의 관계
	@ManyToOne(fetch = FetchType.LAZY)
	private Board board;						// 게시판과 게시판_댓글 유저와의 관계

	}
