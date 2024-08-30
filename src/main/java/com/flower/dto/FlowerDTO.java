package com.flower.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerDTO {

    @Length(min = 10, max = 300)
    private String description;

    @Length(min = 2, max = 50)
    private String name;
}
