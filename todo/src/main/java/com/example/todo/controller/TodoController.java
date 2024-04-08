package com.example.todo.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class TodoController {
    @GetMapping(value = { "/", "/todo/list" })
    public String homeGet() {
        log.info("home");

        return "/todo/list";
    }

}
