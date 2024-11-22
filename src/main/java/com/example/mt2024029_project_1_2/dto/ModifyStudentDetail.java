package com.example.mt2024029_project_1_2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyStudentDetail {
    private Long studentId;
    private String rollNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String photographPath;
    private Double cgpa;
    private Integer totalCredits;
    private Integer graduationYear;

    // Foreign key references
    private Long domainId;
    private Long specializationId;
    private Long placementId;
}
