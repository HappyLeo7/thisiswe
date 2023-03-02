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
@Table(name = "we_place_zone")

//TODO [Entity]place_image 테이블 컬럼 (장소 구역 번호, 장소 번호, 장소 구역 이름)
public class PlaceZoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_zone_num")
	private Long placeZoneNum; // 장소 구역 번호

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "place_num")
	private PlaceEntity placeNum; // 장소 번호

	@Column(length = 100, name = "place_zone_name", nullable = false)
	private String place_zone_name; // 장소 구역 이름

}