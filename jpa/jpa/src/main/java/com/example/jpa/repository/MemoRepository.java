package com.example.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Memo;

// <Entity, Entity>에서의 PK Type
public interface MemoRepository extends JpaRepository<Memo, Long> {
    // spring에서 DAO만들지않음
    // 여기가 DAO역할

    List<Memo> findByMnoLessThan(Long mno);

    List<Memo> findByMnoLessThanOrderByMnoDesc(Long mno);

    // 50 70
    List<Memo> findByMnoBetween(Long start, Long end);

}
