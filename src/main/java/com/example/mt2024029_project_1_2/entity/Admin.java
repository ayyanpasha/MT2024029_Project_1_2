package com.example.mt2024029_project_1_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admins")
@Data  // Generates getters, setters, equals, hashCode, toString methods automatically
@NoArgsConstructor  // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with arguments for all fields
@Builder // Generates the builder pattern for the class
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    @JsonIgnore
    private String password;
}
