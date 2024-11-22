package com.example.mt2024029_project_1_2.controller;

import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping("/detail")
    public ResponseEntity<Student> getDetails(HttpServletRequest httpRequest){
        return studentService.getDetails(httpRequest);
    }
}