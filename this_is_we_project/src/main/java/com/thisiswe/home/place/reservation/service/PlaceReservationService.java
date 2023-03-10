package com.thisiswe.home.place.reservation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.thisiswe.home.place.dto.PlaceDTO;
import com.thisiswe.home.place.entity.PlaceEntity;
import com.thisiswe.home.place.reservation.dto.PlaceReservationDTO;
import com.thisiswe.home.place.reservation.entity.PlaceReservationEntity;
import com.thisiswe.home.place.zone.entity.PlaceZoneEntity;

public interface PlaceReservationService {

	void register(PlaceReservationDTO placeReservationDTO);

	
	// dto -> en 
	default PlaceReservationEntity dtoToEntity(PlaceReservationDTO placeReservationDTO){
		//예약시 사용시간 처리하는곳 ?? ~ ?? 시간
		int timeStart=Integer.parseInt(placeReservationDTO.getPlaceReservationTimeStart());
		int timeEnd=Integer.parseInt(placeReservationDTO.getPlaceReservationTimeEnd());
		System.out.println(" 시작시간: "+timeStart);
		System.out.println(" 끝시간 : "+timeEnd);
		List<String> time=new ArrayList<>();
		for(int i=timeStart;i<timeEnd+1;i++) {
			if(i<10) {
				time.add("0"+i);
				 System.out.println("추가 : 0"+i);
			}
			else {
				time.add(i+"");
				System.out.println("숫자10이상 추가 : "+i);
			}
		}
		System.out.println("요청한시간 : "+time.toString().substring(1,time.toString().length()-1));
		String reservationTime=time.toString().substring(1,time.toString().length()-1);
		
		
			PlaceReservationEntity placeReservationEntity = PlaceReservationEntity.builder()
					//.placeReservationNum(placeReservationDTO.getPlaceReservationNum()
					.placeZoneNum(PlaceZoneEntity.builder()
							.placeNum(PlaceEntity.builder().placeNum(placeReservationDTO.getPlaceNum()).build())
							.placeZoneNum(placeReservationDTO.getPlaceZoneNum()).build())
					.place_reservation_name(placeReservationDTO.getPlace_reservation_name())//예약자명
					.userId(placeReservationDTO.getUserId())//유저ID
					.place_reservation_tel(placeReservationDTO.getPlace_reservation_tel()) //전화번호
					.placeReservationDate(placeReservationDTO.getPlaceReservationDate())//예약날짜
					.placeReservationTime(reservationTime)//예약시간
					.placeReservationHeadcount(placeReservationDTO.getPlaceReservationHeadcount())//인원
					.build();
		System.out.println("저장하기전 placeReservationEntity 정보 :"+placeReservationEntity);
			
		return placeReservationEntity;
	}


	Boolean getCheck(PlaceReservationDTO placeReservationDTO);


	Object getPlaceNumToZoneNumToReservationList(Long placeZoneNum);
	
	//en -> dto
	default PlaceReservationDTO entityToDto(PlaceReservationEntity placeReservationEntity, Long reservationNum) {
		System.out.println("placeReservationEntity : "+placeReservationEntity);
		
		String time=placeReservationEntity.getPlaceReservationTime();
		String timeStrat=time.substring(0,2);
		String timeEnd=time.substring(time.length()-3,time.length());
		System.out.println("시작 시간 : "+timeStrat);
		System.out.println("끝 시간 : "+timeEnd);
		
		PlaceReservationDTO placeReservationDTO = PlaceReservationDTO.builder()
				.placeNum(placeReservationEntity.getPlaceZoneNum().getPlaceNum().getPlaceNum())
				.placeReservationNum(placeReservationEntity.getPlaceReservationNum())
				.place_reservation_name(placeReservationEntity.getPlace_reservation_name())
				.placeZoneNum(placeReservationEntity.getPlaceZoneNum().getPlaceZoneNum())
				.placeReservationDate(placeReservationEntity.getPlaceReservationDate())
				.place_reservation_tel(placeReservationEntity.getPlace_reservation_tel())
				.placeReservationTimeStart(timeStrat)
				.placeReservationTimeEnd(timeEnd)
				.userId(placeReservationEntity.getPlaceZoneNum().getPlaceNum().getUserId())
				.placeReservationHeadcount(placeReservationEntity.getPlaceReservationHeadcount())
				.placeZoneName(placeReservationEntity.getPlaceZoneNum().getPlaceZoneName())
				//.place_reservation_name(null)
				.build();
		
		return placeReservationDTO;
}


	PlaceReservationDTO getRead(Long reservationNum);


	PlaceReservationDTO modify(PlaceReservationDTO placeReservationDTO);
}
