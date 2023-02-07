package com.thisiswe.home.board.notice.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass
@EntityListeners(value= {AuditingEntityListener.class})
@Getter

//TODO [Entity] 공지사항 부분에서 사용 할 수 있도록 추상 클래스 생성. 등록일, 수정일
abstract class BaseEntity { 
	
	@CreatedDate
	@Column(name="notice_reg_date", updatable=false)
	private LocalDateTime notice_reg_date; 			// 공지사항 등록일자
	
	@LastModifiedDate
	@Column(name="notice_update_date")
	private LocalDateTime notice_update_date; 		// 공지사항 수정일자
	
}
