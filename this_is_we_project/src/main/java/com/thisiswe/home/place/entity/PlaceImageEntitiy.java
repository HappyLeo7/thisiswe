package com.thisiswe.home.place.entity;

import com.thisiswe.home.enetity.DateEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "we_place_image")

//TODO [Entity]place_image 테이블 컬럼 (장소 이미지 번호, 장소 번호, uuid, 장소 이미지 이름, 장소 이미지 경로)
public class PlaceImageEntitiy extends DateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_image_num")
	private Long placeImageNum; // 장소 이미지 번호

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_num")
	private PlaceEntity placeNum; // 장소 번호

	@Column(length = 500, name = "place_image_uuid", nullable = false)
	private String placeImageUuid; // uuid

	@Column(length = 300, name = "place_image_name", nullable = false)
	private String placeImageName; // 장소 이미지 이름

	@Column(length = 500, name = "place_image_url", nullable = false)
	private String placeImageUrl; // 장소 이미지 경로

}
