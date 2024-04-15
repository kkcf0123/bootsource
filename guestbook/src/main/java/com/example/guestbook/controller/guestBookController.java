package com.example.guestbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.guestbook.dto.GuestBookDto;
import com.example.guestbook.entity.GuestBook;
import com.example.guestbook.service.GuestBookService;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class guestBookController {

    private final GuestBookService service;

    @GetMapping("/list")
    public void getList(Model model) {
        log.info("request list");

        List<GuestBookDto> list = service.getList();
        model.addAttribute("list", list);
        // model.addAttribute("list", service.getList());
    }

    @GetMapping("/read")
    public void getRead(Long id, Model model) {
        GuestBookDto row = service.getRow(id);
        model.addAttribute("row", row);
    }

}
