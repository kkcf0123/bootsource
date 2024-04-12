package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.jpa.entity.Member2;
import com.example.jpa.entity.Team2;

public interface Member2Repository extends JpaRepository<Member2, Long>, QuerydslPredicateExecutor<Member2> {

    @Query("SELECT m FROM Member2 m")
    List<Member2> findByMembers(Sort sort);

    @Query("SELECT m.userName, m.age FROM Member2 m")
    // List<Member2> findByMembers2();
    List<Object[]> findByMembers2();

    @Query("SELECT m FROM Member2 m WHERE m.age > ?1")
    List<Member2> findByAgeList(int age);

    @Query("SELECT m FROM Member2 m WHERE m.team2 = ?1")
    List<Member2> findByTeamEqual(Team2 team2);
}
