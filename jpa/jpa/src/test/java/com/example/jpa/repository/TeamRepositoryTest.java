package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Team;
import com.example.jpa.entity.TeamMember;

import oracle.security.o3logon.a;

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

    // @FetchType : 연결관계에서 상대정보를 가지고나올지말지
    // @FetchType.Eager : o
    // @fetchType.Lazy : x

    @Test
    public void getRowTest() {
        // team_member(N) : team(1) => PK 제약조건
        // member를 찾고싶을 때 N:1 관계에서는 1에 해당하는 데이터도 같이 가져옴
        // => join필요(left join)
        // inner join : 두 테이블이 서로 일치할 때 가져옴
        // outter join : 두 테이블이 일치하지않아도 가져옴
        // 1) left (outter) join : 일치하지않을 때 왼쪽 테이블 기준
        // 2) right (outter) join : 일치하지않을 때 오른쪽 테이블 기준
        TeamMember teamMember = teamMemberRepository.findById("member1").get();

        System.out.println(teamMember);
        System.out.println("팀 전체 정보 : " + teamMember.getTeam());
        System.out.println("팀 명 : " + teamMember.getTeam().getName());

        teamMemberRepository.findByMemberEquealTeam("team2").forEach(member -> {
            System.out.println(member);
        });
        ;
    }

    @Test
    public void updateTest() {
        // 멤버의 팀 변경
        // 수정할 회원 조회
        TeamMember teamMember = teamMemberRepository.findById("member3").get();
        Team team = Team.builder().id("team3").build();
        teamMember.setTeam(team);

        System.out.println("수정 후 : " + teamMemberRepository.save(teamMember));
    }

    @Test
    public void deleteTest() {
        // 2)
        TeamMember teamMember = teamMemberRepository.findById("member1").get();
        teamMember.setTeam(null);
        teamMemberRepository.save(teamMember);

        // 1)
        // PK 제약조건때문에 한번에 삭제할 수 없음
        teamRepository.deleteById("team1");
    }

    public void getMemberList() {
        Team team = teamRepository.findById("team3").get();

        team.getMembers().forEach(m -> System.out.println(m));
    }
}
