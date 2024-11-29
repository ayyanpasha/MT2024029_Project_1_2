package com.example.mt2024029_project_1_2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationAdd {

    private String educationName;
    private String institutionName;
    private Double percentage;

}
