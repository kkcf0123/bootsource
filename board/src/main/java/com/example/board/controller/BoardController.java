package com.example.board.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.dto.PageResultDto;
import com.example.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public void getList(@ModelAttribute("requestDto") PageRequestDto requestDto, Model model) {
        model.addAttribute("result", service.getList(requestDto));
    }

    @GetMapping(value = { "/read", "/modify" })
    public void getRead(@RequestParam Long bno, Model model) {

        BoardDto dto = service.getRow(bno);
        model.addAttribute("dto", dto);

    }

    @PostMapping("/modify")
    public String postModify(BoardDto dto, RedirectAttributes rttr) {

        service.updateRow(dto);
        rttr.addAttribute("bno", dto.getBno());
        return "redirect:/board/read";
    }

    @PostMapping("/delete")
    public String postMethodName(Long bno) {
        service.removeWithReplies(bno);

        return "redirect:/board/list";
    }

    @GetMapping("/create")
    public void getMethodName(@RequestParam String param) {
    }

    @PostMapping("/create")
    public String postMethodName(@RequestBody String entity) {

        return "redirect:/board/list";
    }

}
