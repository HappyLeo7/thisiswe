package com.thisiswe.home.notice.entity;

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

//TODO [Entity]Notice - Reply table 컬럼(유저ID, 내용)
public class Reply extends DateEntity{
	
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="notice_reply_num")
	private Long noticeReplyNum;				// 공지사항_댓글 번호
	
	@Column(length=100, name="notice_reply_content")
	private String noticeReplyContent;			// 공지사항_댓글 내용

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserEntity userId;					// 공지사항_댓글 유저ID
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="notice_num")
	private Notice noticeNum;					//공지사항 관리자와 유저와의 관계,,,?
	*/
}
