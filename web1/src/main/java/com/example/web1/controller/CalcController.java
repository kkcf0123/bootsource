package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web1.DTO.AddDto;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
@RequestMapping("/calc")
public class CalcController {

    // servlet 역할
    @GetMapping("/add")
    public void addGet() {
        log.info("/calc/add request");
    }

    // // 사용자 입력값 가져오기
    // 1.HttpServletRequest req
    // 2. getParameter이용 (form 변수명과 일치해야됌)
    // 3. DTO
    // - POST 컨트롤러 응답 후 보여지는 화면단에서 dto에 들어있는 값을 사용가능

    // @PostMapping("/add")
    // public void addPost(HttpServletRequest req) {
    // log.info("num1 {}", req.getParameter("num1"));
    // log.info("num2 {}", req.getParameter("num2"));

    // // return;
    // }

    // // spring은 type을 자동으로 변환해줌
    // // 받고자하는 변수의 type을 지정해서 알려주기만하면됨
    // @PostMapping("/add")
    // public void addPost(@RequestParam(value = "num1", defaultValue = "0") int
    // num1,
    // @RequestParam(value = "num2", defaultValue = "0") int num2) {
    // // public void addPost(int num1, int num2) {

    // log.info("num1 {}", num1);
    // log.info("num2 {}", num2);

    // // return;
    // }

    @PostMapping("/add")
    public void addPost(AddDto dto) {
        log.info("/calc/add post request");
        log.info("num1 {}", dto.getNum1());
        log.info("num2 {}", dto.getNum2());
        // dto.setResult(dto.getNum1() + dto.getNum2());
        // model.addAttribute("result", dto.getNum1() + dto.getNum2());
    }

    @GetMapping("/rules")
    public void rulesGet() {
        log.info("rules");
    }

    @PostMapping("/rules")
    public String rulesPost(AddDto addDto, String op, Model model) {
        int result = 0;

        if (op.equals("+")) {
            result = addDto.getNum1() + addDto.getNum2();
        } else if (op.equals("-")) {
            result = addDto.getNum1() - addDto.getNum2();
        } else if (op.equals("*")) {
            result = addDto.getNum1() * addDto.getNum2();
        } else if (op.equals("/")) {
            result = addDto.getNum1() / addDto.getNum2();
        }
        // model.addAttribute("result", result);
        addDto.setResult(result);
        return "/calc/result";

    }

}
