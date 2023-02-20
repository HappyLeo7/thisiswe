package com.thisiswe.home.place.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PlacePageRequestDTO {

	private int page;
	private int size;
	private String type;
	private String keyword;

	public PlacePageRequestDTO() {
		this.page = 1;
		this.size = 10;
	}

	public Pageable getPagealbe(Sort sort) {
		return PageRequest.of(page - 1, size, sort);
	}
}