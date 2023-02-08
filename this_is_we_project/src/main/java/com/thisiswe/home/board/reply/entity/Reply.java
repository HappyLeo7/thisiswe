package com.thisiswe.home.board.reply.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.thisiswe.home.board.free.entity.Board;
import com.thisiswe.home.enetity.DateEntity;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

//TODO [Entity]Reply table 컬럼(유저ID, 내용)
public class Reply extends DateEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_reply_num")
	private Long boardReplyNum;				 	// 게시판_댓글 번호
	
	@Column(length=100, name="board_reply_content")
	private String boardReplyContent;			// 게시판_댓글 내용

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="")
	private UserEntity userId;					// 게시판_댓글 유저ID
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="")
	private Board boardNum;						//게시판 작성자와 회원 닉네임의 관계
	 
}
