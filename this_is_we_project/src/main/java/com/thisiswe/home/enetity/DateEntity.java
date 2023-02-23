package com.thisiswe.home.enetity;


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

//TODO [Entity]Date 컬럼(등록일, 수정일)
public class DateEntity {
	
	//** 등록일자 */
	@CreatedDate
	@Column(name="reg_date", updatable=false)
	private LocalDateTime regDate; //등록일자
	
	//** 수정일자 */
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate; //수정일자
	
}
