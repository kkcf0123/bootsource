package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        List<Todo> list = todoRepository.findByCompleted(false);
        // List<TodoDto> todoList = new ArrayList<>();
        // list.forEach(todo -> todoList.add(entityToDto(todo)));

        List<TodoDto> todoList = list.stream().map(todo -> entityToDto(todo)).collect(Collectors.toList());
        return todoList;
    }

    public TodoDto create(TodoDto dto) {
        Todo entity = todoRepository.save(dtoToEntity(dto));
        return entityToDto(entity);
    }

    public TodoDto getTodo(Long id) {
        Todo entity = todoRepository.findById(id).get();
        return entityToDto(entity);
    }

    public List<TodoDto> getCompletedList() {
        List<Todo> result = todoRepository.findByCompleted(true);

        // List<TodoDto> compList = new ArrayList<>();
        // result.forEach(todo -> compList.add(entityToDto(todo)));
        List<TodoDto> compList = result.stream().map(todo -> entityToDto(todo)).collect(Collectors.toList());
        return compList;
    }

    public Long updateRow(Long id) {
        Todo entity = todoRepository.findById(id).get();
        entity.setCompleted(true);
        Todo todo = todoRepository.save(entity);
        return todo.getId();
    }

    public void deleteRow(Long id) {
        todoRepository.deleteById(id);
    }

    private Todo dtoToEntity(TodoDto dto) {
        return Todo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .completed(dto.getCompleted())
                .important(dto.getImportant())
                .build();
    }

    private TodoDto entityToDto(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .important(todo.getImportant())
                .createdDate(todo.getCreatedDate())
                .lastModifiedDate(todo.getLastModifiedDate())
                .build();
    }
}
