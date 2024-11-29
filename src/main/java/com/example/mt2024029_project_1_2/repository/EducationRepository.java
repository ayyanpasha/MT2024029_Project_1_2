package com.example.mt2024029_project_1_2.repository;

import com.example.mt2024029_project_1_2.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByStudent_StudentId(Long studentId);
}
