package com.thisiswe.home.board.reply.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value= {AuditingEntityListener.class})
@Getter

//TODO [Entity] 댓글 부분에서 사용 할 수 있도록 추상 클래스 생성. 등록일, 수정일
abstract class BaseEntity { 
	
	@CreatedDate
	@Column(name="board_reply_regDate", updatable=false)
	private LocalDateTime board_reply_regDate; 		// 게시판_댓글 등록일자
	
	@LastModifiedDate
	@Column(name="board_reply_updateDate")
	private LocalDateTime board_reply_updateDate; 	// 게시판_댓글 수정일자
}
