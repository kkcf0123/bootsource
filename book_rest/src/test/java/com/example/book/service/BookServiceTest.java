package com.example.book.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.example.book.dto.BookDto;
import com.example.book.dto.PageRequestDto;
import com.example.book.dto.PageResultDto;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Transactional
    @Test
    public void testList() {
        PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).size(10).type("t").keyword("1").build();
        PageResultDto<BookDto, Book> pageResultDto = bookService.getList(pageRequestDto);

        pageResultDto.getDtoList().forEach(System.out::println);
    }

}
