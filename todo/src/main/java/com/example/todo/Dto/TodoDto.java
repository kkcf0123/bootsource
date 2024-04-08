package com.example.todo.Dto;

import java.time.LocalDateTime;

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
public class TodoDto {

    private Long id;

    private String title;

    private Boolean completed;

    private Boolean important;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

}
