package com.example.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.dto.BookDto;
import com.example.book.dto.PageRequestDto;
import com.example.book.dto.PageResultDto;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookService service;

    @GetMapping("/pages/{page}")
    public ResponseEntity<PageResultDto<BookDto, Book>> list(@PathVariable("page") int page) {
        PageRequestDto requestDto = new PageRequestDto();
        requestDto.setPage(page);
        PageResultDto<BookDto, Book> result = service.getList(requestDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<BookDto> read(@PathVariable("id") Long id) {
        BookDto bookDto = service.getRow(id);

        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @PostMapping("/book/new")
    public ResponseEntity<String> postCreate(@Valid BookDto dto) {

        Long id = service.bookCreate(dto);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/modify")
    public String postModify(@RequestBody BookDto updateDto) {
        Long id = service.bookUpdate(updateDto);

        // 조회화면으로 이동
        rttr.addAttribute("id", id);
        // 페이지 나누기 정보
        rttr.addAttribute("page", requestDto.getPage());
        rttr.addAttribute("type", requestDto.getType());
        rttr.addAttribute("keyword", requestDto.getKeyword());
        return "redirect:/book/read";
    }
}
