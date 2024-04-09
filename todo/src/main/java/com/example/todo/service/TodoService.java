package com.example.todo.service;

import java.util.List;

import com.example.todo.Dto.TodoDto;
import com.example.todo.entity.Todo;

public interface TodoService {

    List<TodoDto> getList();

    TodoDto create(TodoDto dto);

    TodoDto getTodo(Long id);

    List<TodoDto> getCompletedList();

    Long updateRow(Long id);

    void deleteRow(Long id);

    public default Todo dtoToEntity(TodoDto dto) {
        return Todo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .completed(dto.getCompleted())
                .important(dto.getImportant())
                .build();
    }

    public default TodoDto entityToDto(Todo todo) {
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