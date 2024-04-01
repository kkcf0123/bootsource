package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController {

    // @RequestMapping(value = "/", method = "RequestMethod.GET")
    @GetMapping
    public String home() {
        log.info("request home");

        // templates 아래 경로부터 시작 확장자 빼고 파일명
        return "index";
    }
}
