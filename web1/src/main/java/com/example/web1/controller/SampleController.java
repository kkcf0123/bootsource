package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/sample")
public class SampleController {

    // String, void 형태의 메소드
    // http://localhost:8080/sample/basic

    // 404 : 경로 없음 (컨트롤러의 맵핑주소 확인)
    // 500 : Error resolving template [sample/basic], template might not exist or
    // might not be accessible
    // templates 폴더 확인

    // return type결정
    // void : 경로와 일치하는 곳에 템플릿이 존재할 때
    // String : 경로와 일치하는 곳에 템플릿이 없을 때(템플릿 위치와 관계없이 자유롭게 지정가능)

    // http://localhost:8080/sample/basic
    // sample 폴더 (경로) basic(html)

    @GetMapping("/basic")
    public void basic() {
        log.info("/sample/basic request");
    }

    @GetMapping("/ex1")
    public void ex1() {
        log.info("/sample/ex1 request");
    }

    @GetMapping("/ex2")
    public String ex2() {
        log.info("/sample/ex2 request");
        // return "/board/create"; //(타 경로)
        return "/index"; // 동일경로

    }

}
