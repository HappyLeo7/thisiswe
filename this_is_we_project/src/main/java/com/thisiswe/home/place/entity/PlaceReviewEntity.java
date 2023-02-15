package com.thisiswe.home.place.entity;

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
@Table(name = "we_place_review")

//TODO [Entity]place_image 테이블 컬럼 (장소 QnA 번호, 장소 번호, 리뷰 내용, 별점, 유저 아이디)
public class PlaceReviewEntity extends DateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_review_num")
	private Long placeReviewNum; // 장소 QnA 번호

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plcae_num")
	private UserEntity placeNum; // 장소 번호

	@Column(length = 300, name = "place_review_content", nullable = false)
	private String placeReviewContent; // 리뷰 내용

	@Column(name = "place_review_rate", nullable = false)
	private Integer placeReviewRate; // 별점
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity userId; //유저 아이디

}