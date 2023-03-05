package com.thisiswe.home.place.zone.service;

import com.thisiswe.home.place.zone.dto.PlaceZoneDTO;
import com.thisiswe.home.place.zone.dto.PlaceZoneTimePriceDTO;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;
import com.thisiswe.home.place.zone.entity.PlaceZoneTimePriceEntity;

public interface PlaceZoneTimePriceService {

	PlaceZoneTimePriceDTO placeZoneTimePriceList(PlaceZoneDTO placeZoneDTO);
	

	//dto -> en
	default PlaceZoneTimePriceEntity dtoToEntity(PlaceZoneTimePriceDTO placeZoneTimePriceDTO) {
		
		
		
		PlaceZoneTimePriceEntity placeZoneTimePriceEntity = PlaceZoneTimePriceEntity.builder()
				.placeZonePriceTime01(placeZoneTimePriceDTO.getPlaceZonePriceTime01())
				.placeZonePriceTime02(placeZoneTimePriceDTO.getPlaceZonePriceTime02())
				.placeZonePriceTime03(placeZoneTimePriceDTO.getPlaceZonePriceTime03())
				.placeZonePriceTime04(placeZoneTimePriceDTO.getPlaceZonePriceTime04())
				.placeZonePriceTime05(placeZoneTimePriceDTO.getPlaceZonePriceTime05())
				.placeZonePriceTime06(placeZoneTimePriceDTO.getPlaceZonePriceTime06())
				.placeZonePriceTime07(placeZoneTimePriceDTO.getPlaceZonePriceTime07())
				.placeZonePriceTime08(placeZoneTimePriceDTO.getPlaceZonePriceTime08())
				.placeZonePriceTime09(placeZoneTimePriceDTO.getPlaceZonePriceTime09())
				.placeZonePriceTime10(placeZoneTimePriceDTO.getPlaceZonePriceTime10())
				.placeZonePriceTime11(placeZoneTimePriceDTO.getPlaceZonePriceTime11())
				.placeZonePriceTime12(placeZoneTimePriceDTO.getPlaceZonePriceTime12())
				.placeZonePriceTime13(placeZoneTimePriceDTO.getPlaceZonePriceTime13())
				.placeZonePriceTime14(placeZoneTimePriceDTO.getPlaceZonePriceTime14())
				.placeZonePriceTime15(placeZoneTimePriceDTO.getPlaceZonePriceTime15())
				.placeZonePriceTime16(placeZoneTimePriceDTO.getPlaceZonePriceTime16())
				.placeZonePriceTime17(placeZoneTimePriceDTO.getPlaceZonePriceTime17())
				.placeZonePriceTime18(placeZoneTimePriceDTO.getPlaceZonePriceTime18())
				.placeZonePriceTime19(placeZoneTimePriceDTO.getPlaceZonePriceTime19())
				.placeZonePriceTime20(placeZoneTimePriceDTO.getPlaceZonePriceTime20())
				.placeZonePriceTime21(placeZoneTimePriceDTO.getPlaceZonePriceTime21())
				.placeZonePriceTime22(placeZoneTimePriceDTO.getPlaceZonePriceTime22())
				.placeZonePriceTime23(placeZoneTimePriceDTO.getPlaceZonePriceTime23())
				.placeZonePriceTime24(placeZoneTimePriceDTO.getPlaceZonePriceTime24())
				.placeZoneNum(PlaceZoneEntity.builder().placeZoneNum(placeZoneTimePriceDTO.getPlaceZoneNum().getPlaceZoneNum()).build())
				.build();
		
		System.out.println("장소zone 시간별 금액 정보 변환 완료 : "+placeZoneTimePriceEntity);
		
		return placeZoneTimePriceEntity;
		
	}
	//en -> dto
	default PlaceZoneTimePriceDTO entityToDto(PlaceZoneTimePriceEntity placeZoneTimePriceEntity) {
		
		
		
		PlaceZoneTimePriceDTO placeZoneTimePriceDTO = PlaceZoneTimePriceDTO.builder()
				.placeZonePriceNum(placeZoneTimePriceEntity.getPlaceZonePriceNum())
				.placeZonePriceTime01(placeZoneTimePriceEntity.getPlaceZonePriceTime01())
				.placeZonePriceTime02(placeZoneTimePriceEntity.getPlaceZonePriceTime02())
				.placeZonePriceTime03(placeZoneTimePriceEntity.getPlaceZonePriceTime03())
				.placeZonePriceTime04(placeZoneTimePriceEntity.getPlaceZonePriceTime04())
				.placeZonePriceTime05(placeZoneTimePriceEntity.getPlaceZonePriceTime05())
				.placeZonePriceTime06(placeZoneTimePriceEntity.getPlaceZonePriceTime06())
				.placeZonePriceTime07(placeZoneTimePriceEntity.getPlaceZonePriceTime07())
				.placeZonePriceTime08(placeZoneTimePriceEntity.getPlaceZonePriceTime08())
				.placeZonePriceTime09(placeZoneTimePriceEntity.getPlaceZonePriceTime09())
				.placeZonePriceTime10(placeZoneTimePriceEntity.getPlaceZonePriceTime10())
				.placeZonePriceTime11(placeZoneTimePriceEntity.getPlaceZonePriceTime11())
				.placeZonePriceTime12(placeZoneTimePriceEntity.getPlaceZonePriceTime12())
				.placeZonePriceTime13(placeZoneTimePriceEntity.getPlaceZonePriceTime13())
				.placeZonePriceTime14(placeZoneTimePriceEntity.getPlaceZonePriceTime14())
				.placeZonePriceTime15(placeZoneTimePriceEntity.getPlaceZonePriceTime15())
				.placeZonePriceTime16(placeZoneTimePriceEntity.getPlaceZonePriceTime16())
				.placeZonePriceTime17(placeZoneTimePriceEntity.getPlaceZonePriceTime17())
				.placeZonePriceTime18(placeZoneTimePriceEntity.getPlaceZonePriceTime18())
				.placeZonePriceTime19(placeZoneTimePriceEntity.getPlaceZonePriceTime19())
				.placeZonePriceTime20(placeZoneTimePriceEntity.getPlaceZonePriceTime20())
				.placeZonePriceTime21(placeZoneTimePriceEntity.getPlaceZonePriceTime21())
				.placeZonePriceTime22(placeZoneTimePriceEntity.getPlaceZonePriceTime22())
				.placeZonePriceTime23(placeZoneTimePriceEntity.getPlaceZonePriceTime23())
				.placeZonePriceTime24(placeZoneTimePriceEntity.getPlaceZonePriceTime24())
				.placeZoneNum(PlaceZoneDTO.builder().placeZoneNum(placeZoneTimePriceEntity.getPlaceZoneNum().getPlaceZoneNum()).build())
				.build();
		
		System.out.println("장소zone 시간별 금액 정보 변환 완료 : "+placeZoneTimePriceDTO);
		
		return placeZoneTimePriceDTO;
		
	}
	
	

	void register(PlaceZoneTimePriceDTO placeZoneTimepriceDTO);
}
