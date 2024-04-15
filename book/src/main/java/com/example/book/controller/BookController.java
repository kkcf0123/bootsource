package com.example.book.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.book.dto.BookDto;
import com.example.book.dto.PageRequestDto;
import com.example.book.dto.PageResultDto;
import com.example.book.entity.Book;
import com.example.book.service.BookService;
import com.example.book.service.BookServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/list")
    public void list(Model model, @ModelAttribute("pageRequestDto") PageRequestDto pageRequestDto) {
        log.info("list 요청");
        PageResultDto<BookDto, Book> result = service.getList(pageRequestDto);
        model.addAttribute("result", result);

    }

    @GetMapping(value = { "/read", "/modify" })
    public void modifyGet(Long id, Model model, PageRequestDto pageRequestDto) {
        BookDto dto = service.getRow(id);
        model.addAttribute("dto", dto);
        log.info("read or modify 요청");
    }

    @PostMapping("/modify")
    public String modifyPost(BookDto updateBookDto, @ModelAttribute("pageRequestDto") PageRequestDto pageRequestDto,
            RedirectAttributes rttr) {
        Long id = service.bookUpdate(updateBookDto);

        // 조회화면으로 이동
        rttr.addAttribute("id", id);

        // 페이지 나누기 정보
        rttr.addAttribute("page", pageRequestDto.getPage());
        rttr.addAttribute("type", pageRequestDto.getType());
        rttr.addAttribute("keyword", pageRequestDto.getKeyword());

        return "redirect:/book/read";
    }

    @GetMapping("/create")
    public void create(BookDto dto, Model model) {
        log.info("create 요청");

        model.addAttribute("categories", service.categoryNameList());
    }

    @PostMapping("/create")
    public String createPost(@Valid BookDto dto, BindingResult result, RedirectAttributes rttr, Model model) {
        if (result.hasErrors()) {
            // category들
            model.addAttribute("categories", service.categoryNameList());
            return "/book/create";
        }

        Long id = service.bookCreate(dto);
        rttr.addFlashAttribute("msg", id);
        return "redirect:/book/list";
    }

    @PostMapping("/delete")
    public String deletePost(Long id) {
        service.bookDelete(id);
        return "redirect:/book/list";
    }

}