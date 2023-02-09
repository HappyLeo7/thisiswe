package com.thisiswe.home.place.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "we_place_tag")

//TODO [Entity]place_image 테이블 컬럼 (장소 태그 번호, 장소 번호, 태그 내용)
public class PlaceTagEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_tag_num")
	private Long placeTagNum; // 장소 태그 번호

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_num")
	private PlaceEntity placeNum; // 장소 번호

	@Column(length = 100, name = "place_tag_content", nullable = false)
	private String placeTagContent; // 장소 태그 내용

}
