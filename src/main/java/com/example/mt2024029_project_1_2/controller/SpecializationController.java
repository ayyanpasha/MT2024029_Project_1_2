package com.example.mt2024029_project_1_2.controller;

import com.example.mt2024029_project_1_2.entity.Specialization;
import com.example.mt2024029_project_1_2.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpecializationController {
    @Autowired
    private SpecializationRepository specializationRepository;

    @GetMapping("/specialization")
    public List<Specialization> getAllSpecialization(){
        return specializationRepository.findAll();
    }
}
