package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Member;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    // List<Member> findByUserNmae(String userName);
}
