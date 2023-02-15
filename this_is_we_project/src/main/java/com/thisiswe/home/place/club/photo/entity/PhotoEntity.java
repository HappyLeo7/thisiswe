package com.thisiswe.home.place.club.photo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.thisiswe.home.place.club.entity.ClubEntity;
import com.thisiswe.home.enetity.DateEntity;

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
public class PhotoEntity extends DateEntity{
	
	//PK생성
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photo_num")
	private Long photoNum; //사진번호
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_num")
	private ClubEntity clubNum; //모임번호
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private ClubEntity userId; //유저ID
	
	
	@Column(length = 1000, name = "photo_image")
	private String photoImage; //사진이미지
	@Column(length = 1000, name = "photo_content")
	private String photoContent; //사진 내용
	@Column(name = "photo_view")
	private Long photoView; // 조회수
	
	
	

}
