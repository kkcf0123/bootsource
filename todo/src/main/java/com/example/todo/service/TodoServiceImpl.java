package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.Dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl {
    private final TodoRepository todoRepository;

    public List<TodoDto> getList() {
        List<Todo> list = todoRepository.findAll();
        List<TodoDto> todoList = new ArrayList<>();
        list.forEach(todo -> todoList.add(entityToDto(todo)));
        return todoList;
    }

    private TodoDto entityToDto(Todo entity) {
        return TodoDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .completed(entity.getCompleted())
                .important(entity.getImportant())
                .createdDate(entity.getCreatedDate())
                .lastModifiedDate(entity.getLastModifiedDate())
                .build();
    }
}
