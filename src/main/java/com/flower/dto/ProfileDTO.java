package com.flower.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    @NotBlank
    @Length(min = 5, max = 50)
    private String fio;

    @NotBlank
    @Length(min = 5, max = 20)
    private String login;

    @NotBlank
    @Length(min = 8, max = 50)
    private String password;
}
