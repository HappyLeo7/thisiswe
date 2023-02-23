package com.thisiswe.home.user.mypage;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
//TODO [DTO]PageResult - 공지사항
public class MyPageResultDTO<DTO, EN> {

    private List<DTO> DTOList;

    private int totalPage;
    private int page;
    private int size;

    private int start, end;
    private boolean prev, next;
    private List<Integer> pageList;

    public MyPageResultDTO(Page<EN> result, Function<EN, DTO> func) {
        DTOList = result.stream().map(func).collect(Collectors.toList());
        totalPage = result.getTotalPages();

        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {
        this.page = pageable.getPageNumber() + 1;
        this.size = pageable.getPageSize();
        int tempEnd = (int)(Math.ceil(page/10.0)) * 10;

        this.start = tempEnd -9;

        this.prev = start > 1;
        this.end = totalPage > tempEnd ? tempEnd + 1 : totalPage + 1;
        this.next = totalPage > tempEnd;

        this.pageList = IntStream.rangeClosed(start, end)
                        .boxed().collect(Collectors.toList());
    }
}
