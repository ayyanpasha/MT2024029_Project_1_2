package com.example.mt2024029_project_1_2.controller;

import com.example.mt2024029_project_1_2.dto.ChangePassword;
import com.example.mt2024029_project_1_2.dto.ModifyStudentDetail;
import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;


    @GetMapping("/detail")
    public ResponseEntity<Student> getDetails(HttpServletRequest httpRequest){
        return studentService.getDetails(httpRequest);
    }

    @PostMapping("/detail")
    public ResponseEntity<String> modifyDetails(@RequestBody ModifyStudentDetail modifyStudentDetail, HttpServletRequest httpRequest){
        return studentService.modify(modifyStudentDetail, httpRequest);
    }

    @PostMapping("/password")
    public ResponseEntity<String> changePassword(@RequestBody @Valid ChangePassword changePassword, HttpServletRequest httpRequest){
        return studentService.changePassword(changePassword, httpRequest);
    }

}
