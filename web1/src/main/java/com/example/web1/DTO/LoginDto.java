package com.example.web1.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {
    @Length(min = 2, max = 6)
    @NotBlank // @NotNull + "" 값 불가
    private String name;

    @Email(message = "check email.")
    @NotEmpty // @NotEmpty + "" 값 불가
    private String email;
}
