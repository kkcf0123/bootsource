package com.example.book.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString(exclude = "books")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publisher extends BaseEntity {

    @SequenceGenerator(name = "book_publisher_seq_gen", sequenceName = "book_publisher_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_publisher_seq_gen")
    @Id
    @Column(name = "publisher_id")
    private Long id;

    @Column(name = "publisher_name", nullable = false)
    private String name;

    // manytoone의 반대는 list
    @Builder.Default
    @OneToMany(mappedBy = "publisher") // book에 publisher를 연결할 때 넣은 로컬변수
    private List<Book> books = new ArrayList<>();
}
