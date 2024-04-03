package com.example.web1.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {

    @NotBlank
    // @Pattern(regexp = "")
    private String id;

    @NotBlank
    @Length(min = 2, max = 6)
    private String password;

    @NotNull(message = "check age.")
    @Min(value = 1)
    @Max(value = 100)
    private Integer age;

    @Email(message = "check email.")
    @NotEmpty
    private String email;

    @NotBlank
    @Length(min = 2, max = 6)
    private String name;
}
