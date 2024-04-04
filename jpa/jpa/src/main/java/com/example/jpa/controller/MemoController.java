// package com.example.jpa.controller;

// import java.util.List;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.GetMapping;

// import lombok.RequiredArgsConstructor;
// import lombok.extern.log4j.Log4j2;

// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.jpa.Dto.MemoDto;
// import com.example.jpa.service.MemoServiceImpl;

// import jakarta.validation.Valid;

// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// @Log4j2
// @Controller
// @RequestMapping("/memo")
// @RequiredArgsConstructor // final로 생성된게 있으면 무조건 들어와야함
// public class MemoController {
// private final MemoServiceImpl service;

// @GetMapping("/list")
// public void getMemoList(Model model) {
// log.info("/memo/list request");
// List<MemoDto> list = service.getMemoList();

// // list를 list.html에 뿌림
// model.addAttribute("list", list);

// }

// // /memo/read?mno=3 - GET
// // @GetMapping("/read")
// // public void getRead(@RequestParam Long mno, Model model) {
// // log.info("read request");
// // MemoDto mDto = service.getMemo(mno);
// // model.addAttribute("mDto", mDto);
// // }

// // /memo/read?mno=3 + GET
// // /memo/modify?mno=3 + GET
// @GetMapping({ "/read", "/modify" })
// public void getRead(@RequestParam Long mno, Model model) {
// log.info("read request");

// MemoDto mDto = service.getMemo(mno);
// model.addAttribute("mDto", mDto);
// }

// @PostMapping("/modify")
// public String modifyPost(MemoDto mDto, RedirectAttributes rttr) {

// MemoDto updateDto = service.updateMemo(mDto);

// rttr.addAttribute("mno", updateDto.getMno());

// // 수정완료시 read로 이동
// return "redirect:/memo/read";
// }

// @GetMapping("/delete")
// public String deleteGet(@RequestParam Long mno) {
// log.info("delete Mno", mno);
// service.deleteMemo(mno);

// return "redirect:/memo/list";
// }

// @GetMapping("/create")
// public void createGet() {
// log.info("memo form request");
// }

// // @PostMapping("path")
// // public String postMethodName(@Valid MemoDto mDto, BindingResult result) {
// // TODO: process POST request

// // return entity;
// }

// }
