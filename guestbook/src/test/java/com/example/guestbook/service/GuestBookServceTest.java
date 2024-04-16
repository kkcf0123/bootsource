package com.example.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.guestbook.dto.GuestBookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.entity.GuestBook;

@SpringBootTest
public class GuestBookServceTest {

    @Autowired
    private GuestBookService service;

    @Test
    public void testList() {
        PageRequestDto requestDto = PageRequestDto.builder().page(1).size(10).type("tc").keyword("쥬시쿨").build();

        PageResultDto<GuestBookDto, GuestBook> result = service.getList(requestDto);

        System.out.println("prev : " + result.isPrev());
        System.out.println("next : " + result.isNext());
        System.out.println("total : " + result.getTotalPage());

        result.getPageList().forEach(System.out::println);
        result.getDtoList().forEach(System.out::println);

    }

}