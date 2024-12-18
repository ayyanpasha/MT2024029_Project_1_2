package com.example.mt2024029_project_1_2.mapper;

import com.example.mt2024029_project_1_2.dto.SignupRequest;
import com.example.mt2024029_project_1_2.entity.Domain;
import com.example.mt2024029_project_1_2.entity.Placement;
import com.example.mt2024029_project_1_2.entity.Specialization;
import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.repository.DomainRepository;
import com.example.mt2024029_project_1_2.repository.PlacementRepository;
import com.example.mt2024029_project_1_2.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupToStudentMapper {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private PlacementRepository placementRepository;

    public Student toEntity(SignupRequest request){
    Domain defaultDomain = domainRepository.findById(1L).orElseThrow(() -> new RuntimeException("Default Domain not found"));
    Specialization defaultSpecialization = specializationRepository.findById(1L).orElseThrow(() -> new RuntimeException("Default Specialization not found"));
    Placement defaultPlacement = placementRepository.findById(1L).orElseThrow(() -> new RuntimeException("Default Placement not found"));

        return Student.builder()
                .rollNumber(request.getUsername())
                .password(request.getPassword())
                .firstName("NEW")
                .lastName("NEW")
                .cgpa(8.8)
                .email(request.getEmail())
                .domain(defaultDomain)
                .specialization(defaultSpecialization)
                .placement(defaultPlacement)
                .graduationYear(2026)
                .roleUser("user")
                .photographPath("/image/"+request.getUsername()+".jpg")
                .totalCredits(0)
                .build();
}
}
