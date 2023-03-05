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
public class PlaceZoneTimePriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "we_place_zone_price_num")
	private Long PlaceZonePriceNum; // 시간 별 금액 번호

	@Column(name = "place_zone_price_time_01", nullable = false)
	private Long placeZonePriceTime01; // 시간별 금액
	@Column(name = "place_zone_price_time_02", nullable = false)
	private Long placeZonePriceTime02;
	@Column(name = "place_zone_price_time_03", nullable = false)
	private Long placeZonePriceTime03;
	@Column(name = "place_zone_price_time_04", nullable = false)
	private Long placeZonePriceTime04;
	@Column(name = "place_zone_price_time_05", nullable = false)
	private Long placeZonePriceTime05;
	@Column(name = "place_zone_price_time_06", nullable = false)
	private Long placeZonePriceTime06;
	@Column(name = "place_zone_price_time_07", nullable = false)
	private Long placeZonePriceTime07;
	@Column(name = "place_zone_price_time_08", nullable = false)
	private Long placeZonePriceTime08;
	@Column(name = "place_zone_price_time_09", nullable = false)
	private Long placeZonePriceTime09;
	@Column(name = "place_zone_price_time_10", nullable = false)
	private Long placeZonePriceTime10;
	@Column(name = "place_zone_price_time_11", nullable = false)
	private Long placeZonePriceTime11;
	@Column(name = "place_zone_price_time_12", nullable = false)
	private Long placeZonePriceTime12;
	@Column(name = "place_zone_price_time_13", nullable = false)
	private Long placeZonePriceTime13;
	@Column(name = "place_zone_price_time_14", nullable = false)
	private Long placeZonePriceTime14;
	@Column(name = "place_zone_price_time_15", nullable = false)
	private Long placeZonePriceTime15;
	@Column(name = "place_zone_price_time_16", nullable = false)
	private Long placeZonePriceTime16;
	@Column(name = "place_zone_price_time_17", nullable = false)
	private Long placeZonePriceTime17;
	@Column(name = "place_zone_price_time_18", nullable = false)
	private Long placeZonePriceTime18;
	@Column(name = "place_zone_price_time_19", nullable = false)
	private Long placeZonePriceTime19;
	@Column(name = "place_zone_price_time_20", nullable = false)
	private Long placeZonePriceTime20;
	@Column(name = "place_zone_price_time_21", nullable = false)
	private Long placeZonePriceTime21;
	@Column(name = "place_zone_price_time_22", nullable = false)
	private Long placeZonePriceTime22;
	@Column(name = "place_zone_price_time_23", nullable = false)
	private Long placeZonePriceTime23;
	@Column(name = "place_zone_price_time_24", nullable = false)
	private Long placeZonePriceTime24;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_zone_num")
	private PlaceZoneEntity placeZoneNum; // 장소 구역 번호
	

}