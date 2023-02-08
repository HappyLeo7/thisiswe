package com.thisiswe.home.board.notice.entity;

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
@ToString

//TODO [Entity]Notice table 컬럼(공지사항 번호, 카테고리, 제목, 내용, 유저ID, 조회수)
public class Notice extends DateEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="notice_num")
	private Long noticeNum;						// 공지사항 번호
	
	@Column(length=100, name="notice_category")
	private String noticeCategory;				// 공지사항 카테고리
	
	@Column(length=100, name="notice_title")
	private String noticeTitle;					// 공지사항 제목
	
	@Column(length=100, name="notice_content")
	private String noticeContent;				// 공지사항 내용
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="")
	private UserEntity userId;					// 공지사항 유저ID
	
	@Column(length=100, name="notice_view")
	private int noticeView;						// 공지사항 조회수	
	
	/*
	//연관 관계 - 공지사항과 관리자, 게시판=n 관리자=1 n:1 관계다. 그래서 @ManyToOne를 넣어줘야한다.
	@ManyToOne(fetch = FetchType.Lazy)
	private //시큐리티,,?
	*/
	
	//NoticeServiceImpl.java와 연결된다.
	//수정하는 부분 - title과 content
	public void change(String noticeTitle, String noticeContent) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}
	
}	
