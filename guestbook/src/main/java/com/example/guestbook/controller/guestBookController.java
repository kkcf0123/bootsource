package com.example.guestbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.guestbook.dto.GuestBookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.entity.GuestBook;
import com.example.guestbook.service.GuestBookService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Log4j2
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestBookController {

    private final GuestBookService service;

    @GetMapping("/list")
    public void getList(PageRequestDto requestDto, Model model) {

        PageResultDto<GuestBookDto, GuestBook> result = service.getList(requestDto);

        model.addAttribute("result", service.getList(requestDto));
        // List<GuestBookDto> list = service.getList();
        // model.addAttribute("list", list);
        // model.addAttribute("list", service.getList());

    }

    @GetMapping(value = { "/read", "/modify" })
    public void getRead(@RequestParam Long gno, Model model) {
        GuestBookDto dto = service.getRow(gno);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/modify")
    public String postModify(RedirectAttributes rttr, GuestBookDto guestBookDto) {

        Long gno = service.updateRow(guestBookDto);

        rttr.addAttribute("gno", gno);
        return "redirect:/guestbook/read";
    }

    @PostMapping("/delete")
    public String postDelete(@RequestParam Long gno, RedirectAttributes rttr) {
        service.deleteRow(gno);

        return "redirect:/guestbook/list";
    }

    @GetMapping("/create")
    public void create(GuestBookDto dto, Model model) {
        // model.addAttribute("createDto", service.createRow(dto));
    }

    @PostMapping("/create")
    public String createPost(@Valid GuestBookDto dto, BindingResult result, RedirectAttributes rttr,
            Model model) {

        if (result.hasErrors()) {
            return "/guestbook/create";
        }

        Long gno = service.createRow(dto);
        rttr.addFlashAttribute("msg", gno);
        return "redirect:/guestbook/list";
    }
}
