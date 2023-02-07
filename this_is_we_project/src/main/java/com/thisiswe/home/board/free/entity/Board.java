package com.thisiswe.home.board.free.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

//TODO [Entity]Board table 컬럼(게시글 번호, 카테고리, 제목, 내용, 유저ID, 조회수)
public class Board extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_num;					// 게시글 번호
	
	@Column(length=100)
	private String board_category;			// 게시판 카테고리
	
	@Column(length=100)
	private String board_title;				// 게시판 제목
	
	@Column(length=100)
	private String board_content;			// 게시판 내용
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user_id;				// 게시판 유저ID
	
	@Column(length=100)
	private int board_view;					// 게시판 조회수	
	
}
