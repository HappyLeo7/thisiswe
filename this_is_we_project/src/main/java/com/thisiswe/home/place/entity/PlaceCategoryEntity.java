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

import com.thisiswe.home.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "we_place_category")

//TODO [Entity]place_image 테이블 컬럼 (장소 유형 번호, 장소 번호, 장소 유형)
public class PlaceCategory {

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
