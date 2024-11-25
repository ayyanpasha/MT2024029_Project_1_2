package com.example.mt2024029_project_1_2.service;

import com.example.mt2024029_project_1_2.auth.JWTService;
import com.example.mt2024029_project_1_2.auth.StudentPrincipal;
import com.example.mt2024029_project_1_2.dto.ChangePassword;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private SpecializationRepository specializationRepository;
    @Autowired
    private PlacementRepository placementRepository;

    public UserDetails loadUserByUsername(String rollnumber) throws UsernameNotFoundException {
        Student student = studentRepository.findByRollNumber(rollnumber);
        if(student == null) {
            throw new UsernameNotFoundException(rollnumber);
        }
        return new StudentPrincipal(student);
    }

    public ResponseEntity<Student> getDetails(HttpServletRequest httpRequest) {
        String rollNumber = getRollNumber(httpRequest);
        if(rollNumber == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentRepository.findByRollNumber(rollNumber));
    }

    public String getRollNumber(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");

        String token = authHeader != null && authHeader.startsWith("Bearer ") ? authHeader.substring(7) : null;

        return (token != null) ? jwtService.extractUserName(token):null;
    }

    public ResponseEntity<String> modify(ModifyStudentDetail modifyStudentDetail, HttpServletRequest httpRequest) {
        String rollNumber = getRollNumber(httpRequest);
        if(rollNumber == null) {
            return ResponseEntity.notFound().build();
        }

        Student student = studentRepository.findByRollNumber(rollNumber);
        if (student == null) {
            return ResponseEntity.notFound().build();  // If student not found, return 404.
        }

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
        if (modifyStudentDetail.getPhotographPath() != null) {
            student.setPhotographPath(modifyStudentDetail.getPhotographPath());
        }
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
        studentRepository.save(student);

        return ResponseEntity.ok("Student details updated successfully");
    }

    public ResponseEntity<String> changePassword(ChangePassword changePassword, HttpServletRequest httpRequest) {
        String rollNumber = getRollNumber(httpRequest);

        if (rollNumber == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        Student student = studentRepository.findByRollNumber(rollNumber);
        if (student == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        if (!passwordEncoder.matches(changePassword.getOldPassword(), student.getPassword())) {
            return ResponseEntity.status(400).body("Old password is incorrect");
        }

        String newPassword = changePassword.getNewPassword();

        String encodedNewPassword = passwordEncoder.encode(newPassword);

        student.setPassword(encodedNewPassword);
        studentRepository.save(student);

        return ResponseEntity.ok("Password updated successfully");
    }
}
