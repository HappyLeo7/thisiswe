package com.thisiswe.home.board.notice.entity;

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

//TODO [Entity]Notice table 컬럼(공지사항 번호, 카테고리, 제목, 내용, 유저ID, 조회수)
public class Notice extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notice_num;					// 공지사항 번호
	
	@Column(length=100)
	private String notice_category;				// 공지사항 카테고리
	
	@Column(length=100)
	private String notice_title;				// 공지사항 제목
	
	@Column(length=100)
	private String notice_content;				// 공지사항 내용
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user_id;					// 공지사항 유저ID
	
	@Column(length=100)
	private int notice_view;					// 공지사항 조회수	
}	
