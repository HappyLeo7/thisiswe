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
@Table(name = "we_place")

//TODO [Entity]place 테이블 컬럼 (장소번호, 유저ID, 장소명, 한줄 소개, 소개글, 영업 시간, 휴무일, 환불 규정, 주소, 전화 번호 좌표, 안내 사항,  주의 사항)
public class PlaceEntity extends DateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_num")
	private Long placeNum; // 장소 번호

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity userId; // 유저 ID

	
	
	@Column(length = 50, name = "place_name", nullable = false)
	private String placeName; // 장소명

	@Column(length = 200, name = "place_one_line_introduction", nullable = false)
	private String placeOneLineIntroduction; // 한줄 소개

	@Column(length = 3000, name = "place_introduction", nullable = false)
	private String placeIntroduction; // 소개글

	@Column(length = 200, name = "place_business_hours", nullable = false)
	private String placeBusinessHours; // 영업 시간

	@Column(length = 100, name = "place_holiday", nullable = false)
	private String placeHoliday; // 휴무일

	@Column(length = 1000, name = "place_refund_regulations", nullable = false)
	private String placeRefundRegulations; // 환불 규정

	@Column(length = 200, name = "place_address", nullable = false)
	private String placeAddress; // 주소

	@Column(length = 200, name = "place_phone_number", nullable = false)
	private String placePhoneNumber; // 전화 번호

	@Column(length = 100, name = "place_coordinate", nullable = false)
	private String placeCoordinate; // 좌표

	@Column(length = 5000, name = "place_guide", nullable = false)
	private String placeGuide; // 안내 사항

	@Column(length = 200, name = "place_caution", nullable = false)
	private String placeCaution; // 주의 사항

}
