package com.thisiswe.home.place.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PlaceReviewPageRequestDTO {

	private int page;
	private int size;
	private Long placeNum;

	public PlaceReviewPageRequestDTO(Long placeNum) {
		this.page = 1;
		this.size = 10;
		this.placeNum = placeNum;
	}

	public Pageable getPagealbe(Sort sort) {
		return PageRequest.of(page - 1, size, sort);
	}
}
