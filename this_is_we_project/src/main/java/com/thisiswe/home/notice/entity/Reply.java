package com.thisiswe.home.notice.entity;

import com.thisiswe.home.enetity.DateEntity;

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
