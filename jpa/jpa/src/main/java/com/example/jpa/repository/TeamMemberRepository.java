package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, String> {

    // not sql
    @Query("select m, t from TeamMember m join m.team t where t.name=?1")
    public List<TeamMember> findByMemberEquealTeam(String teamName);
}
