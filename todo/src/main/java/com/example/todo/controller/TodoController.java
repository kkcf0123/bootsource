package com.example.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.todo.Dto.TodoDto;
import com.example.todo.service.TodoServiceImpl;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoServiceImpl service;
    // 멤버변수 초기화 - 1) constructor 2) setter

    @GetMapping("/list")
    public String homeGet(Model model) {
        log.info("home");

        List<TodoDto> list = service.getList();

        // list를 어딘가에 뿌려주려면 model에 담아야함
        model.addAttribute("list", list);
        return "/todo/list";
    }

    @GetMapping("/create")
    public void createGet() {
        log.info("create request");
    }

    @PostMapping("/create")
    public String postMethodName(TodoDto dto, RedirectAttributes rttr) {
        TodoDto result = service.create(dto);

        rttr.addFlashAttribute("msg", result.getId());
        return "redirect:/todo/list";
    }

    @GetMapping("/read")
    public void readGet(@RequestParam Long id, Model model) {
        TodoDto todo = service.getTodo(id);

        // rttr.addFlashAttribute(result);
        model.addAttribute("todo", todo);
    }

    @GetMapping("/done")
    public void doneGet(Model model) {
        List<TodoDto> list = service.getCompletedList();
        model.addAttribute("list", list);
    }

    @PostMapping("/update")
    public String updatePost(@RequestParam Long id, RedirectAttributes rttr) {
        Long id2 = service.updateRow(id);

        rttr.addAttribute("id", id2);
        return "redirect:/todo/read";
    }

    @PostMapping("/delete")
    public String deletePost(@RequestParam Long id) {
        service.deleteRow(id);
        return "redirect:/todo/list";
    }

}
