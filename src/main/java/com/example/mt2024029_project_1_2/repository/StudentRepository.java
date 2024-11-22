package com.example.mt2024029_project_1_2.repository;

import com.example.mt2024029_project_1_2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByRollNumber(String rollNumber);
}
