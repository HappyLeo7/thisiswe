package com.thisiswe.home.place.zone.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "we_place_zone_timeprice")

//TODO [Entity]place_image 테이블 컬럼 (시간 별 금액 번호, 시간, 금액 ,장소 구역 번호)
public class PlaceZoneTimepriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "we_place_zone_price_num")
	private Long wePlaceZonePriceNum; // 시간 별 금액 번호

	@Column(name = "place_zone_price_time", nullable = false)
	private Long placeZonePriceTime; // 시간

	@Column(name = "place_zone_timeprice_price", nullable = false)
	private Long placeZoneTimepricePrice; // 금액
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_zone_num")
	private PlaceZoneEntity placeZoneNum; // 장소 구역 번호
	

}