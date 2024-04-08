package com.example.todo.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

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

@DynamicInsert
@Table(name = "TODOTBL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Todo extends BaseEntity {

    @Id
    @SequenceGenerator(name = "todo_seq_gen", sequenceName = "todo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq_gen")
    @Column(name = "TODO_ID")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @ColumnDefault("0") // sql의 default를 지정하는 것과 같음
    private Boolean completed;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean important;

    // jpa에서 default값을 자동삽입하려면 @DynamicInsert가 필요함
    // @DynamicInsert : 데이터가 존재하는 필드만으로 insert sql 문 생성

}
