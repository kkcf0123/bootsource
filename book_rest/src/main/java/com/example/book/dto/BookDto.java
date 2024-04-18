package com.example.book.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {

    private Long id;
    @NotBlank(message = "제목을 입력해주세요")
    private String title;
    @NotBlank(message = "writer를 입력해주세요")
    private String writer;
    @NotNull(message = "price를 입력해주세요")
    private Integer price;
    @NotNull(message = "sale price를 입력해주세요")
    private Integer salePrice;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    // relationship
    @NotBlank(message = "category를 입력해주세요")
    private String categoryName;
    @NotBlank(message = "publisher를 입력해주세요")
    private String publisherName;
}
