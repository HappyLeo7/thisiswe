package com.thisiswe.home.club.photo.entity;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.enetity.DateEntity;
import lombok.*;

import javax.persistence.*;

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
