package com.example.mt2024029_project_1_2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Roll Number is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
}
