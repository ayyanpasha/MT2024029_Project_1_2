package com.example.mt2024029_project_1_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "domains")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long domainId;

    @Column(nullable = false)
    private String program;

    @Column(nullable = false)
    private String batch;

    private int capacity;

    private String qualification;

    @OneToMany(mappedBy = "domain", fetch = FetchType.LAZY)
    private List<Student> students;
}
