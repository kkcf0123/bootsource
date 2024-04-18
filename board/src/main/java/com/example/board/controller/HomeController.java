package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class HomeController {

    // @GetMapping(value = "/")
    // public String homeGet() {
    // log.info("request home");

    // return "/board/list";
    // }

    @GetMapping(value = "/")
    public String homeGet(RedirectAttributes rttr) {
        log.info("request home");

        return "redirect:/board/list";
    }

}
