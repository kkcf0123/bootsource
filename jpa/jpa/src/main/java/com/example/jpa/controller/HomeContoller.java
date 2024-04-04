package com.example.jpa.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class HomeContoller {

    @GetMapping("/")
    public String homeGet() {
        log.info("request home");
        return "/memo/home";

    }

    // @PostMapping("/home")
    // public void homePost() {

    // return entity;
    // }

}
