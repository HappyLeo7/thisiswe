package com.thisiswe.home.club.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@ToString(exclude="userId")

//TODO [Entity]Board table 컬럼(게시글 번호, 카테고리, 제목, 내용, 유저ID, 조회수, 댓글수)
public class Board extends DateEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_num")
	private Long boardNum;						// 게시글 번호
	
	@Column(length=100, name="board_category")
	private String boardCategory;				// 게시판 카테고리
	
	@Column(length=100, name="board_title")
	private String boardTitle;					// 게시판 제목
	
	@Column(length=100, name="board_content")
	private String boardContent;				// 게시판 내용
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserEntity userId;					// 게시판 유저ID
	
	@Column(length=100, name="board_view")
	private Long boardView;						// 게시판 조회수	
	
	@Column(length=100, name="board_replyCount")
	private Long replyCount;					// 게시판 댓글수
	
	//boardServiceImpl.java와 연결된다.
	//TODO [Entity] 게시판 수정하는 부분 - category, title, content
	public void change(String boardCategory, String boardTitle, String boardContent) {
		this.boardCategory = boardCategory;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}
	
}
