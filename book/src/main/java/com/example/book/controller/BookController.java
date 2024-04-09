package com.example.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    @GetMapping("/list")
    public String bookList() {

        return "/book/list";
    }

    @GetMapping("/create")
    public String ModifyGet() {
        return "/book/create";
    }
}
