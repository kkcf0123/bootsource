package com.example.web1.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web1.DTO.SampleDto;

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
    public void basic(Model model) {
        log.info("/sample/basic request");

        // ${name}
        model.addAttribute("name", "hong gil dong");

        // SampleDto sampleDto = new SampleDto();
        // sampleDto.setFirst("first");
        // sampleDto.setId(1L);
        // sampleDto.setLast("last");
        // sampleDto.setRegTime(LocalDateTime.now());

        // lombok builder pattern
        // SampleDto sampleDto = SampleDto.builder()
        // .first("first")
        // .id(1L)
        // .last("last")
        // .regTime(LocalDateTime.now())
        // .build();

        List<SampleDto> list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            SampleDto dto = SampleDto.builder()
                    .first("first")
                    .id(1L)
                    .last("last")
                    .regTime(LocalDateTime.now())
                    .build();
            list.add(dto);
        }
        // "dto"는 html에서 사용
        model.addAttribute("list", list);
        model.addAttribute("now", new Date());
        model.addAttribute("price", 123456789);
        model.addAttribute("title", "this is a just sample");
        model.addAttribute("options", Arrays.asList("AAAA", "BBBB"));

    }

    @GetMapping("/ex1")
    public void ex1(Model model) {
        log.info("/sample/ex1 request");
        model.addAttribute("result", "SUCCESS");
    }

    @GetMapping("/ex2")
    public String ex2() {
        log.info("/sample/ex2 request");
        // return "/board/create"; //(타 경로)
        return "/index"; // 동일경로
    }

    @GetMapping("/ex3")
    public void ex3() {
        log.info("/sample/ex3 request");

    }

    @GetMapping("/ex4")
    public void ex4(String param1, String param2, Model model) {
        log.info("param1 : {}, param2 : {}", param1, param2);
        model.addAttribute("param1", 10);
        model.addAttribute("param2", 20);
    }

    @GetMapping("/ex5")
    public void ex5() {
        log.info("ex5 request");
    }

    @GetMapping("/ex6")
    public void ex6() {
        log.info("ex6 request");
    }

}
