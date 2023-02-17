package com.thisiswe.home.notice.entity;

import com.thisiswe.home.enetity.DateEntity;
import com.thisiswe.home.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;

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
	private Long noticeNum;								// 공지사항 번호
	
	@Column(length=100, name="notice_category")
	private String noticeCategory;						// 공지사항 카테고리
	
	@Column(length=100, name="notice_title")
	private String noticeTitle;							// 공지사항 제목
	
	@Column(length=100, name="notice_content")
	private String noticeContent;						// 공지사항 내용
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private UserEntity userId;							// 공지사항 유저ID
	
	@Column(length=100, name="notice_view")
	private int noticeView;								// 공지사항 조회수	
	
	/*
	//연관 관계 - 공지사항과 관리자, 게시판=n 관리자=1 n:1 관계다. 그래서 @ManyToOne를 넣어줘야한다.
	@ManyToOne(fetch = FetchType.Lazy)
	private //시큐리티,,?
	*/
	/*
	 * 
	// TODO [Entity] 컬렉션 관리를 위한 별도 테이블 생성
	@ElementCollection(fetch = FetchType.LAZY)
	@Builder.Default
	private Set<UserRole> roleSet = new HashSet<>(); // 중복 허용 x
	*/
	
	
	
	
	//NoticeServiceImpl.java와 연결된다.
	//수정하는 부분 - title과 content
	public void change(String noticeTitle, String noticeContent) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}
	
}	
