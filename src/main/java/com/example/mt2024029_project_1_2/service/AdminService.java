package com.example.mt2024029_project_1_2.service;

import com.example.mt2024029_project_1_2.dto.ModifyStudentDetail;
import com.example.mt2024029_project_1_2.entity.Domain;
import com.example.mt2024029_project_1_2.entity.Placement;
import com.example.mt2024029_project_1_2.entity.Specialization;
import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.repository.DomainRepository;
import com.example.mt2024029_project_1_2.repository.PlacementRepository;
import com.example.mt2024029_project_1_2.repository.SpecializationRepository;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final StudentRepository studentRepository;
    private final DomainRepository domainRepository;
    private final SpecializationRepository specializationRepository;
    private final PlacementRepository placementRepository;

    public AdminService(StudentRepository studentRepository, DomainRepository domainRepository, SpecializationRepository specializationRepository, PlacementRepository placementRepository) {
        this.studentRepository = studentRepository;
        this.domainRepository = domainRepository;
        this.specializationRepository = specializationRepository;
        this.placementRepository = placementRepository;
    }

    public ResponseEntity<String> modifyStudentDetail(Long studentId, ModifyStudentDetail modifyStudentDetail, HttpServletRequest request) {
        if(!studentRepository.existsById(studentId)) {
            return ResponseEntity.notFound().build();
        }

        Student student = studentRepository.findById(studentId).get();

        if (modifyStudentDetail.getRollNumber() != null) {
            student.setRollNumber(modifyStudentDetail.getRollNumber());
        }
        if (modifyStudentDetail.getFirstName() != null) {
            student.setFirstName(modifyStudentDetail.getFirstName());
        }
        if (modifyStudentDetail.getLastName() != null) {
            student.setLastName(modifyStudentDetail.getLastName());
        }
        if (modifyStudentDetail.getEmail() != null) {
            student.setEmail(modifyStudentDetail.getEmail());
        }
//        if (modifyStudentDetail.getPhotographPath() != null) {
//            student.setPhotographPath(modifyStudentDetail.getPhotographPath());
//        }
        if (modifyStudentDetail.getCgpa() != null) {
            student.setCgpa(modifyStudentDetail.getCgpa());
        }
        if (modifyStudentDetail.getTotalCredits() != null) {
            student.setTotalCredits(modifyStudentDetail.getTotalCredits());
        }
        if (modifyStudentDetail.getGraduationYear() != null) {
            student.setGraduationYear(modifyStudentDetail.getGraduationYear());
        }

        if (modifyStudentDetail.getDomainId() != null) {
            Domain domain = domainRepository.findById(modifyStudentDetail.getDomainId()).orElse(null);
            if (domain != null) {
                student.setDomain(domain);
            } else {
                return ResponseEntity.badRequest().body("Invalid Domain ID");
            }
        }

        if (modifyStudentDetail.getSpecializationId() != null) {
            Specialization specialization = specializationRepository.findById(modifyStudentDetail.getSpecializationId()).orElse(null);
            if (specialization != null) {
                student.setSpecialization(specialization);
            } else {
                return ResponseEntity.badRequest().body("Invalid Specialization ID");
            }
        }

        if (modifyStudentDetail.getPlacementId() != null) {
            Placement placement = placementRepository.findById(modifyStudentDetail.getPlacementId()).orElse(null);
            if (placement != null) {
                student.setPlacement(placement);
            } else {
                return ResponseEntity.badRequest().body("Invalid Placement ID");
            }
        }

        System.out.println(student);
        System.out.println(modifyStudentDetail);
        studentRepository.save(student);

        return ResponseEntity.ok("Student details updated successfully");
    }
}
