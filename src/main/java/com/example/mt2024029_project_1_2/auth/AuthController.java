package com.example.mt2024029_project_1_2.auth;

import com.example.mt2024029_project_1_2.dto.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.verify(loginRequest);
    }

    @PostMapping("/signup")
    public String register(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.signup(loginRequest);
    }
}
