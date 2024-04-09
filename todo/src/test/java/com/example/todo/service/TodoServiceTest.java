package com.example.todo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.todo.Dto.TodoDto;

@SpringBootTest
public class TodoServiceTest {

    @Autowired
    private TodoServiceImpl service;

    @Test
    public void serviceList() {
        System.out.println(service.getList());
    }

    @Test
    public void serviceCreate() {
        TodoDto dto = new TodoDto();
        dto.setTitle("스프링");
        dto.setImportant(true);
        System.out.println(service.create(dto));
    }

    @Test
    public void getRow() {
        System.out.println(service.getTodo(9L));
    }
}
