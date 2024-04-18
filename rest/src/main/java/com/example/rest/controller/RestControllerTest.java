package com.example.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.SampleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// controller
// @Controller - method 종료 후 찾는 대상은 templates(html)
// @RestController - date => data 자체 리턴 가능
// object - object를 return 할 수 있음

@RestController
public class RestControllerTest {

    @GetMapping("/hello")
    public String getHello() {
        return "hello world";
    }

    @GetMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public SampleDto getSameple() {

        SampleDto dto = new SampleDto();
        dto.setMno(1L);
        dto.setFirstName("hong");
        dto.setLastName("GuilDong");
        return dto;
    }

    @GetMapping(value = "/sample2", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SampleDto> getSameple2() {
        List<SampleDto> list = new ArrayList<>();
        LongStream.rangeClosed(1, 10).forEach(i -> {
            SampleDto dto = new SampleDto();
            dto.setMno(i);
            dto.setFirstName("hong" + i);
            dto.setLastName("GuilDong" + i);
            list.add(dto);
        });
        return list;
    }

    // ResponseEntity : 일반 컨트롤러에서도 리턴 값이 데이터임
    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SampleDto> getCheck(double height, double weight) {
        SampleDto dto = new SampleDto();
        dto.setMno(1L);
        dto.setFirstName(String.valueOf(height));
        dto.setLastName(String.valueOf(weight));

        if (height < 150) {
            return new ResponseEntity<SampleDto>(dto, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<SampleDto>(dto, HttpStatus.OK);
        }
    }

    @GetMapping("/product/{cat}/{pid}")
    public String[] getProduct(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
        return new String[] {
                "category : " + cat,
                "productId :" + pid
        };
    }

}
