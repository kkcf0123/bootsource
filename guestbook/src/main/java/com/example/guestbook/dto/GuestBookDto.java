package com.example.guestbook.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
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
public class GuestBookDto {
    private Long gno;

    @NotBlank(message = "check Writer")
    private String title;

    @NotBlank(message = "check Title")
    private String writer;

    @NotBlank(message = "check Content")
    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;
}
