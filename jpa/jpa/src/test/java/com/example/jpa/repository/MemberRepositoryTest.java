package com.example.jpa.repository;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Member;
import com.example.jpa.entity.RoleType;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void createTest() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Member member = Member.builder()
                    .id("user" + i)
                    .userName("user" + i)
                    .age(i)
                    .roleType(RoleType.USER)
                    .description("user" + i)
                    .build();
            memberRepository.save(member);
        });

    }

    @Test
    public void readTest() {
        // memberRepository.findAll().forEach(member -> System.out.println(member));
        memberRepository.findById("user1");
        memberRepository.findByUserNmae("user1").forEach(member -> System.out.println(member));
    }

    @Test
    public void updateTest() {
        Optional<Member> result = memberRepository.findById("user1");

        result.ifPresent(member -> {
            member.setRoleType(RoleType.ADMIN);
            memberRepository.save(member);
        });

    }

    @Test
    public void deleteTest() {
        Member member = memberRepository.findById("user8").get();
        memberRepository.delete(member);
    }
}
