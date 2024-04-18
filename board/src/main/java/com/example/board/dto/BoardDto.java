package com.example.board.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long bno;

    private String title;

    private String content;

    private String writerEmail;
    private String writerName;

    private Long replyCount;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;
}
