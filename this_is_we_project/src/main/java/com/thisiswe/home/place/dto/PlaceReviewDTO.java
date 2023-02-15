package com.thisiswe.home.place.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceReviewDTO {

	private Long placeReviewNum;

	private Long placeNum;

	private String userId;
	
	private String writer;

	private String placeReviewContent;

	private Integer placeReviewRate;

	private LocalDateTime regDate, updateDate;
}
