package com.thisiswe.home.place.entity;

import com.thisiswe.home.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "we_place_category")

//TODO [Entity]place_image 테이블 컬럼 (장소 유형 번호, 장소 번호, 장소 유형)
public class PlaceCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_category_num")
	private Long placeCategoryNum; // 장소 유형 번호

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_num")
	private UserEntity placeNum; // 장소 번호

	@Column(length = 500, name = "place_category_content", nullable = false)
	private String placeCategoryContent; // 장소 유형

}
