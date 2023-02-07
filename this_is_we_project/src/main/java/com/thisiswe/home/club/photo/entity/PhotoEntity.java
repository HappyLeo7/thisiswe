package com.thisiswe.home.club.photo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.entity.DateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhotoEntity extends DateEntity{
	
	//PK생성
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long photo_num; //사진번호
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ClubEntity club_num; //모임번호
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ClubEntity user_id; //유저ID
	
	
	@Column(length = 1000)
	private String photo_image; //사진이미지
	@Column(length = 1000)
	private String photo_content; //사진 내용
	@Column
	private Long photo_view; // 조회수
	
	
	

}
