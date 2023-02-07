package com.thisiswe.home.club.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(value= {AuditingEntityListener.class})
@Getter

//TODO [Entity]Date 컬럼(등록일, 수정일)
public class DateEntity {
	
	@CreatedDate
	@Column(name="reg_date", updatable=false)
	private LocalDateTime regDate; //등록일자
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate; //수정일자
	
}
