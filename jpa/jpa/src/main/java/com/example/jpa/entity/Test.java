package com.example.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Test {

    @Id
    private Long id;
    private long id2;
    private int id3;
    private Integer id4;

}
