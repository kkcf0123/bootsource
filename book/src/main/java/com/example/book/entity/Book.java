package com.example.book.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "BOOKTBL")
@Builder
@Getter
@Setter
@ToString(exclude = { "category", "publisher" })
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {

    @Id
    @SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_gen")
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private Integer price;

    private Integer salePrice;

    // ~One = fetchType : eager(default)
    //
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;
}
