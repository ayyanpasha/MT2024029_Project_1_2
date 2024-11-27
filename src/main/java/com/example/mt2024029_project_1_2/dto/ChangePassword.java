package com.example.mt2024029_project_1_2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangePassword {

    @NotNull(message = "Old password cannot be null")
    @NotEmpty(message = "Old password cannot be empty")
    private String oldPassword;

    @NotNull(message = "Old password cannot be null")
    @NotEmpty(message = "Old password cannot be empty")
    private String newPassword;
}
