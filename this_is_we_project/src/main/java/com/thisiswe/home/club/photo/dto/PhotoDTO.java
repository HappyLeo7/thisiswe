package com.thisiswe.home.club.photo.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.enetity.DateEntity;
import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO extends DateEntity{
	
		/** 사진번호*/
		private Long photoNum; 
		/** 모임번호 */
		private ClubEntity clubNum; //모임번호
		/** 유저ID */
		private UserEntity userId; //유저ID
		/** 사진이미지 */
		private String photoImage; //사진 이미지 이름
		/**사진경로 */
		private String photoPath; //사진 경로
		/** 사진내용 */
		private String photoContent; //사진 내용
		

}
