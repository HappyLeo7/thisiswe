package com.thisiswe.home.place.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceImageDTO {

	private String placeUuid;
	private String placeImgName;
	private String placeImageUrl;
	
	public String getPlaceImageURL() {
		try {
			return URLEncoder.encode(placeImageUrl + "/" + placeUuid + "_" + placeImgName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String getPlcaeThumbnailURL() {

		try {
			return URLEncoder.encode(placeImageUrl + "/s_" + placeUuid + "_" + placeImgName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return "";
	}
}
