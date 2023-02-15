package com.thisiswe.home.place.dto;

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
	
	private String placeCoordinate;
	
	private String placeGuide;
	
	private String placeCaution;
	
	private String placeCategory;
	
}
