package com.example.mt2024029_project_1_2.mapper;

import com.example.mt2024029_project_1_2.dto.EducationAdd;
import com.example.mt2024029_project_1_2.entity.*;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationAddMapper {

    @Autowired
    private StudentRepository studentRepository;
    public Education toEntity(EducationAdd request, Long studentId){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student"));
        return Education.builder()
                .EducationName(request.getEducationName())
                .InstitutionName(request.getInstitutionName())
                .percentage(request.getPercentage())
                .student(student)
                .build();
    }
}
