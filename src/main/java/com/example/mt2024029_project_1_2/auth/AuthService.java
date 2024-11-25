package com.example.mt2024029_project_1_2.auth;

import com.example.mt2024029_project_1_2.dto.LoginRequest;
import com.example.mt2024029_project_1_2.dto.SignupRequest;
import com.example.mt2024029_project_1_2.mapper.SignupToStudentMapper;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SignupToStudentMapper signupToStudentMapper;

    public String verify(LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.getUsername());
        }
        return "Fail";
    }

    @Transactional
    public String signup(@Valid SignupRequest student) {
        String encodedPassword = passwordEncoder.encode(student.getPassword());

        student.setPassword(encodedPassword);

        studentRepository.save(signupToStudentMapper.toEntity(student));

        return jwtService.generateToken(student.getUsername());
    }
}
