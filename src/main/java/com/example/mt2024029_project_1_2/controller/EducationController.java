package com.example.mt2024029_project_1_2.controller;

import com.example.mt2024029_project_1_2.dto.EducationAdd;
import com.example.mt2024029_project_1_2.dto.EducationDeleteRequest;
import com.example.mt2024029_project_1_2.dto.EducationDetail;
import com.example.mt2024029_project_1_2.service.EducationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping("/education")
    public List<EducationDetail> getEducation(HttpServletRequest httpRequest){
        return educationService.getEducation(httpRequest);
    }

    @PostMapping("/education")
    public ResponseEntity<String> postEducation(@RequestBody EducationAdd educationAdd, HttpServletRequest httpRequest){
        return educationService.postEducation(educationAdd, httpRequest);
    }

    @DeleteMapping("/education")
    public ResponseEntity<String> deleteEducation(@RequestBody EducationDeleteRequest educationDeleteRequest, HttpServletRequest httpRequest){
        System.out.println("DELETING EDUCATION");
        return educationService.deleteEducation(educationDeleteRequest.getEducationId(),httpRequest);
    }
}
