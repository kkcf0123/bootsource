package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web1.DTO.LoginDto;
import com.example.web1.DTO.MemberDto;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public void loginGet(LoginDto loginDto) {
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
    // get은 degisn post에서만 사용 가능
    // @Valid LoginDto : loginDto의 유효성 검사
    @PostMapping("/login")
    public String loginPost(@Valid LoginDto loginDto, BindingResult result) {
        log.info("name : {}", loginDto.getName());
        log.info("email : {}", loginDto.getEmail());

        // model.addAttribute("page", page); = @ModelAttribute("page")
        if (result.hasErrors()) {
            return "/member/login";
        }
        return "/member/info";
    }
    // 데이터 보내기
    // request.setAttribut("name", vaule) == model

    @GetMapping("/join")
    public void joinGet(MemberDto memberDto) {
    }

    @PostMapping("/join")
    public String joinPost(@Valid MemberDto memberDto, BindingResult result) {
        if (result.hasErrors()) {
            return "/member/join";
        }
        return "redirect:/member/login";
    }

}
