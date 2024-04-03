package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Memo;

// <Entity, Entity>에서의 PK Type
public interface MemoRepository extends JpaRepository<Memo, Long> {
    // spring에서 DAO만들지않음
    // 여기가 DAO역할

}
