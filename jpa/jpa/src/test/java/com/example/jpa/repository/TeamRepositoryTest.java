package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Team;
import com.example.jpa.entity.TeamMember;

@SpringBootTest
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Test
    public void insertTest() {
        Team team1 = teamRepository.save(Team.builder().id("team1").name("팀1").build());
        Team team2 = teamRepository.save(Team.builder().id("team2").name("팀2").build());
        Team team3 = teamRepository.save(Team.builder().id("team3").name("팀3").build());

        teamMemberRepository.save(TeamMember.builder().id("member1").userName("hong1").team(team1).build());
        teamMemberRepository.save(TeamMember.builder().id("member2").userName("hong2").team(team2).build());
        teamMemberRepository.save(TeamMember.builder().id("member3").userName("hong3").team(team2).build());
        teamMemberRepository.save(TeamMember.builder().id("member4").userName("hong4").team(team3).build());
    }

    @Test
    public void getRowTest() {
        TeamMember teamMember = teamMemberRepository.findById("member1").get();
        System.out.println(teamMember);
    }
}
