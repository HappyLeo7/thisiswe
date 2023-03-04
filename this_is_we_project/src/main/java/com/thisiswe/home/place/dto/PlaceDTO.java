package com.thisiswe.home.place.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {
	
	private Long placeNum;
	
	private String placeName;
	
	private String userId;
	
	private String placeOneLineIntroduction;
	
	private String placeIntroduction;
		
	private String placeBusinessHours;
	
	private String placeHoliday;
	
	private String placeRefundRegulations;
	
	private String placeAddress;
	
	private String placePhoneNumber;
	
	private String placeGuide;
	
	private String placeCaution;
	
	private String placeCategory;
	
	private double placeAvg;
	
	private int placeReviewCount;
	
	@Builder.Default
	private List<PlaceImageDTO> placeImageDTOList = new ArrayList<>();
	
	private LocalDateTime placeRegDate;
	
	private LocalDateTime placeUpdateDate;
	
}
