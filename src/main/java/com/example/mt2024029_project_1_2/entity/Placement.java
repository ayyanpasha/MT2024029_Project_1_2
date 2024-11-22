package com.example.mt2024029_project_1_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "placement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String organization;

    @Column(nullable = false)
    private String profile;

    private String description;

    private int intake;

    private double minimumGrade;
}