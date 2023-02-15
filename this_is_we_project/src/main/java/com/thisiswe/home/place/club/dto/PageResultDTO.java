package com.thisiswe.home.place.club.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PageResultDTO<DTO, EN> {

	 private List<DTO> dtoList;
	  
	   private int totalPage;
	   private int page;
	   private int size;
	   private int start, end;
	   private boolean prev, next;
	   private List<Integer> pageList;
	   
	   public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
		   System.out.println("[PageResultDTO 위치 체크 result :"+result+"]");
		   System.out.println("[PageResultDTO 위치 체크 fn :"+fn+"]");
	      dtoList = result.stream().map(fn).collect(Collectors.toList());
	      System.out.println("[PageResultDTO 위치 체크 dtoList : "+dtoList+"]");

	      System.out.println("[[[[[PageResultDTO 위치 체크]]]]]22");
	      totalPage = result.getTotalPages();
	      System.out.println("[[[[[PageResultDTO 위치 체크]]]]]3");
	      makePageList(result.getPageable());
	   }

	   private void makePageList(Pageable pageable) {
	      
	      this.page = pageable.getPageNumber() + 1;
	      this.size = pageable.getPageSize();
	      int tempEnd = (int)(Math.ceil(page/10.0)) * 10;
	      
	      this.start = tempEnd -9;
	      
	      this.prev = start > 1;
	      this.end = totalPage > tempEnd ? tempEnd : totalPage;
	      this.next = totalPage > tempEnd;
	      
	      this.pageList = IntStream.rangeClosed(start, end)
	                     .boxed().collect(Collectors.toList());
	      System.out.println("[makePageList 위치 체크 pageList : "+pageList+"]4");
	   }
}
