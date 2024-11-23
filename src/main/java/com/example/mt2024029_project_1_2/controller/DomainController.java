package com.example.mt2024029_project_1_2.controller;

import com.example.mt2024029_project_1_2.entity.Domain;
import com.example.mt2024029_project_1_2.repository.DomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DomainController {
    @Autowired
    private DomainRepository domainRepository;

    @GetMapping("domain")
    public List<Domain> getDomains(){
        return domainRepository.findAll();
    }
}
