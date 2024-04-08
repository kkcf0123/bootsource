package com.example.jpa.repository;

import java.util.concurrent.locks.Lock;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Locker;
import com.example.jpa.entity.SportsMember;

@SpringBootTest
public class LockerRepositoryTest {

    @Autowired
    private SportsMemberRepository sportsMemberRepository;

    @Autowired
    private LockerRepository lockerRepository;

    @Test
    public void insertTest() {
        // locker insert
        // LongStream.rangeClosed(1, 4).forEach(i -> {
        // Locker locker = Locker.builder().name("locker" + i).build();
        // lockerRepository.save(locker);

        // });

        LongStream.range(1, 4).forEach(i -> {
            SportsMember sportsMember = SportsMember.builder().name("user" + i).locker(Locker.builder().id(i).build())
                    .build();
            sportsMemberRepository.save(sportsMember);
        });
    }

    public void readTest() {
        SportsMember sportsMember = sportsMemberRepository.findById(1L).get();
        System.out.println(sportsMember);
        System.out.println(sportsMember.getLocker().getId());
        System.out.println(sportsMember.getLocker().getName());
    }

    public void readTest2() {
        Locker locker = lockerRepository.findById(1L).get();
        System.out.println(locker.getSportsMember().getId());
        System.out.println(locker.getSportsMember().getName());
    }

    public void updateTest() {
        SportsMember sportsMember = sportsMemberRepository.findById(1L).get();
        sportsMember.setName("hong");
        sportsMemberRepository.save(sportsMember);
    }
}
