package com.thisiswe.home.place.club.board.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

//TODO [DTO]PageRequest - 게시판
public class PageRequestDTO {
	
	private int page;
	private int size;
	private String type;
	private String keyword;
	
	public PageRequestDTO() {
		this.page = 1;
		this.size = 10;
	}
	
	public Pageable getPageable(Sort sort) {
		return PageRequest.of(page -1, size, sort);
	}

}
