package com.example.mt2024029_project_1_2.controller;

import com.example.mt2024029_project_1_2.dto.ModifyStudentDetail;
import com.example.mt2024029_project_1_2.entity.Domain;
import com.example.mt2024029_project_1_2.entity.Placement;
import com.example.mt2024029_project_1_2.entity.Specialization;
import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.repository.DomainRepository;
import com.example.mt2024029_project_1_2.repository.PlacementRepository;
import com.example.mt2024029_project_1_2.repository.SpecializationRepository;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import com.example.mt2024029_project_1_2.service.AdminService;
import com.example.mt2024029_project_1_2.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private SpecializationRepository specializationRepository;
    @Autowired
    private PlacementRepository placementRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;

    @GetMapping("student")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @PostMapping("student/{studentId}")
    public ResponseEntity<String> modifyStudentDetail(@PathVariable Long studentId, @RequestBody ModifyStudentDetail modifyStudentDetail, HttpServletRequest request){
        System.out.println(modifyStudentDetail);
        return adminService.modifyStudentDetail(studentId,modifyStudentDetail,request);
    }

    @GetMapping("student/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        if(studentRepository.findById(studentId).isPresent()){
            return studentRepository.findById(studentId).get();
        }
        return null;
    }
}
