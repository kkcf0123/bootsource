package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.entity.Todo;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByCompleted(Boolean completed);

    // where completed=? order by id desc
    List<Todo> findByCompletedOrderByIdDesc(Boolean completed);

    // important colum
    List<Todo> findByImportant(Boolean important);

}
