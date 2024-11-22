package com.example.mt2024029_project_1_2.service;

import com.example.mt2024029_project_1_2.auth.JWTService;
import com.example.mt2024029_project_1_2.auth.StudentPrincipal;
import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private StudentRepository studentRepository;

    public UserDetails loadUserByUsername(String rollnumber) throws UsernameNotFoundException {
        Student student = studentRepository.findByRollNumber(rollnumber);
        if(student == null) {
            throw new UsernameNotFoundException(rollnumber);
        }
        return new StudentPrincipal(student);
    }

    public ResponseEntity<Student> getDetails(HttpServletRequest httpRequest) {
        String rollNumber = getRollNumber(httpRequest);
        if(rollNumber == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentRepository.findByRollNumber(rollNumber));
    }

    public String getRollNumber(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");

        String token = authHeader != null && authHeader.startsWith("Bearer ") ? authHeader.substring(7) : null;

        return (token != null) ? jwtService.extractUserName(token):null;
    }
}
