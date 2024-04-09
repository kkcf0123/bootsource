package com.example.book.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String writer;
    private Integer price;

    @Column(name = "sale_price")
    private Integer salePrice;

}
