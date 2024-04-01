package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web1.DTO.MemberDto;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public void loginGet() {
        log.info("/member/login request");
    }

    // @PostMapping("/login")
    // public void loginPost(String name, String email) {
    // log.info("name : {}", name);
    // log.info("email : {}", email);
    // }

    // @PostMapping("/login")
    // public void loginPost(MemberDto loginDto) {
    // log.info("name : {}", loginDto.getName());
    // log.info("email : {}", loginDto.getEmail());

    // }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute("memberDto") MemberDto memberDto, @ModelAttribute("page") int page,
            Model model) {
        log.info("name : {}", memberDto.getName());
        log.info("email : {}", memberDto.getEmail());
        log.info("page : {}", page);

        // model.addAttribute("page", page); = @ModelAttribute("page")

        return "/member/info";
    }
    // 데이터 보내기
    // request.setAttribut("name", vaule) == model
}
