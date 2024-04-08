package com.example.todo.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.todo.entity.Todo;

@SpringBootTest
public class TodoRepositoryTest {

    // DAO가 작동하는지 테스트할 것임
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void insertTest() {
        // insert into todotbl
        // (completed,created_date,important,last_modified_date,title,todo_id) values
        // (?,?,?,?,?,?)
        // IntStream.rangeClosed(1, 10).forEach(i -> {
        // Todo todo = Todo.builder().title("강아지 목욕 " +
        // i).completed(false).important(true).build();
        // todoRepository.save(todo);
        // });

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Todo todo = Todo.builder().title("강아지 목욕 " + i).build();
            todoRepository.save(todo);
        });

    }

    @Test
    public void todoList() {
        todoRepository.findAll().forEach(todo -> System.out.println(todo));
    }

    @Test
    public void todoRow() {
        System.out.println(todoRepository.findById(3L));
    }

    @Test
    public void todoCompletedList() {
        todoRepository.findByCompleted(true).forEach(todo -> System.out.println(todo));
    }

    @Test
    public void todoImportantList() {
        todoRepository.findByImportant(true).forEach(todo -> System.out.println(todo));
    }

    @Test
    public void todoUpdateTitle() {
        Todo todo = todoRepository.findById(2L).get();
        todo.setTitle("고양이 목욕");
        todoRepository.save(todo);

        Todo todo1 = todoRepository.findById(3L).get();
        todo1.setCompleted(false);
        todo1.setImportant(false);
        todoRepository.save(todo1);

        Todo todo2 = todoRepository.findById(4L).get();
        todo2.setTitle("고양이 목욕");
        todo2.setCompleted(false);
        todo2.setImportant(false);
        todoRepository.save(todo2);
    }

    @Test
    public void deleteTodo() {
        todoRepository.deleteById(10L);
    }

}
