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
    @Size(min = 8, max = 20, message = "Old password must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$",
            message = "Old password must contain at least one uppercase letter, one number, and one special character")
    private String newPassword;
}
