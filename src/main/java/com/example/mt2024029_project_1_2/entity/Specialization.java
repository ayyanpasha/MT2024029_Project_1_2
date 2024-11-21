package com.example.mt2024029_project_1_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "specialization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specializationId;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    private int years;

    private int creditsRequired;

    // One-to-many relationship with Student
    @OneToMany(mappedBy = "specialization", fetch = FetchType.LAZY)
    private List<Student> students;
}