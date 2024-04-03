package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
public class HomeController {

    // @RequestMapping(value = "/", method = "RequestMethod.GET")
    @GetMapping("/")
    public String home() {
        log.info("request home");

        // templates 아래 경로부터 시작 확장자 빼고 파일명
        return "index";
    }

    // RedirectAttributes : redirect시에 데이터까지 전달할 수 있음
    @GetMapping("/ex3")
    public String ex3(RedirectAttributes rttr) {
        log.info("/ex3 request");
        // response.sendRedirect("")
        // redirect는 template 띄우는게 아님
        // /로 지정하면 다시 '/'로 보낸다는 얘기임

        // model = forward로 전송

        // http://localhost:8080/sample/basic?bno=15
        // rttr.addAttribute("bno", 15);

        // http://localhost:8080/sample/basic;jsessionid=032884B7D39337F6F6E73ACC1431D5C9
        // session으로 값을 전달
        rttr.addFlashAttribute("bno", 13);
        return "redirect:/sample/basic"; // 경로 지정 (다른컨트롤러에 있는 경로 포함)
    }

    // error가 날 수 밖에 없음. mapping되어있는 페이지를 맵핑하려고하기때문에 에러가 발생하고 서버가 안켜짐
    // @GetMapping("/ex3")
    // public void ex4() {
    // log.info("/ex3 request1");
    // }

}
