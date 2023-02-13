package com.thisiswe.home.board.reply.entity;

import com.thisiswe.home.board.free.entity.Board;
import com.thisiswe.home.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

//TODO [Entity]Reply table 컬럼(유저ID, 내용)
public class Reply extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_reply_num;				// 게시판_댓글 번호
	
	@Column(length=100)
	private String board_reply_content;			// 게시판_댓글 내용

	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user_id;					// 게시판_댓글 유저ID
	
	@ManyToOne(fetch = FetchType.LAZY) 
	private Board board_num; //게시판 작성자와 회원 닉네임의 관계
	 
}
