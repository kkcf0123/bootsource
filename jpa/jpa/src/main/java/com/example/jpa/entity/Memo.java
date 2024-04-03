package com.example.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "memotbl")
@Entity // DB에서 데이터로 관리하는 대상
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Memo {

    // GenerationType.AUTO : create sequence memotbl_seq start with 1 increment by
    // 50
    // GenerationType.IDENTITY(기본키생성은 DB에 위임) : generated as identity
    // GenerationType.SEQUENCE : create sequence memotbl_seq start with 1 increment
    // by 50
    @SequenceGenerator(name = "memo_seq_gen", sequenceName = "memo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memo_seq_gen")
    @Id // == primary key
    private Long mno;

    // 자바변수는 (snake방식 x) (Camel o)
    @Column(nullable = false, length = 300)
    private String memoText;

}
