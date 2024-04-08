package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Child;
import com.example.jpa.entity.Parent;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ParentRepositoryTest {
    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Test
    public void insertTest() {
        Parent p = Parent.builder().name("parent1").build();
        parentRepository.save(p);

        Child c1 = Child.builder().name("child1").parent(p).build();
        childRepository.save(c1);
        Child c2 = Child.builder().name("child2").parent(p).build();
        childRepository.save(c2);
    }

    @Test
    public void insertCascadeTest() {
        Parent p = Parent.builder().name("parent2").build();

        Child c1 = Child.builder().name("child1").parent(p).build();
        p.getChildList().add(c1);
        Child c2 = Child.builder().name("child2").parent(p).build();
        p.getChildList().add(c2);

        childRepository.save(c1);
        childRepository.save(c2);
        parentRepository.save(p);
    }

    @Test
    public void deleteTest() {
        Parent p = Parent.builder().id(1L).build();

        // 1) 자식을 먼저 날리고 부모를 날리든지
        Child c1 = Child.builder().id(1L).build();
        childRepository.delete(c1);
        Child c2 = Child.builder().id(2L).build();
        childRepository.delete(c2);

        //
        // Child c1 = Child.builder().id(1L).parent(null).build();
        // Child c2 = Child.builder().id(2L).parent(null).build();

        // childRepository.save(c1);
        // childRepository.save(c2);
        parentRepository.delete(p);
    }

    @Test
    public void deleteCascadeTest() {
        Parent p = Parent.builder().id(51L).build();

        // 1) 자식을 먼저 날리고 부모를 날리든지
        Child c1 = Child.builder().id(102L).build();
        p.getChildList().add(c1);
        Child c2 = Child.builder().id(103L).build();
        p.getChildList().add(c2);

        parentRepository.delete(p);
    }

    // @Transactional
    // @Test
    // public void deleteOrphanTest() {
    // Parent p = parentRepository.findById(2L).get();

    // Child c1 = Child.builder().name("child1").parent(p).build();
    // childRepository.save(c1);
    // Child c2 = Child.builder().name("child2").parent(p).build();
    // childRepository.save(c2);

    // p.getChildList().add(Child.builder().name("child1").build());
    // childRepository.save(c1);
    // p.getChildList().add(Child.builder().name("child2").build());

    // parentRepository.save(p);
    // }

    @Transactional
    @Test
    public void deleteOrphanTest() {
        Parent p = parentRepository.findById(2L).get();
        System.out.println("기존의 자식" + p.getChildList());

        p.getChildList().remove(0);
        parentRepository.save(p);

    }
}
