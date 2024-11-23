package com.example.mt2024029_project_1_2.controller;

import com.example.mt2024029_project_1_2.entity.Placement;
import com.example.mt2024029_project_1_2.repository.PlacementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlacementController {
    @Autowired
    private PlacementRepository placementRepository;

    @GetMapping("/placement")
    public List<Placement> getAllPlacements(){
        return placementRepository.findAll();
    }
}
