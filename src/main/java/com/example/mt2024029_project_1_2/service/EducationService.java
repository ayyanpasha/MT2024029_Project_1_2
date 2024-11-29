package com.example.mt2024029_project_1_2.service;

import com.example.mt2024029_project_1_2.dto.EducationAdd;
import com.example.mt2024029_project_1_2.dto.EducationDetail;
import com.example.mt2024029_project_1_2.entity.Education;
import com.example.mt2024029_project_1_2.mapper.EducationAddMapper;
import com.example.mt2024029_project_1_2.repository.EducationRepository;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EducationAddMapper educationAddMapper;

    @Autowired
    private StudentService studentService;

    public Long getStudentId(HttpServletRequest request){
        String rollNumber = studentService.getRollNumber(request);
        return studentRepository.findByRollNumber(rollNumber).getStudentId();
    }

    public List<EducationDetail> getEducation(HttpServletRequest request) {
        Long studentId = getStudentId(request);
        List<Education> educations = educationRepository.findByStudent_StudentId(studentId);

        // Map Education entities to EducationDetail DTOs
        return educations.stream()
                .map(education -> new EducationDetail(
                        education.getEducationId(),
                        education.getEducationName(),
                        education.getInstitutionName(),
                        education.getPercentage()))
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> postEducation(EducationAdd educationAdd, HttpServletRequest httpRequest) {
        Long studentId = getStudentId(httpRequest);
        educationRepository.save(educationAddMapper.toEntity(educationAdd,studentId));

        return ResponseEntity.ok("Success");
    }

    public ResponseEntity<String> deleteEducation(Long educationId, HttpServletRequest httpRequest) {
        Long studentId = getStudentId(httpRequest);
        Education education = educationRepository.findById(educationId).get();
        if(education.getStudent().getStudentId().equals(studentId)){
            if (educationRepository.existsById(educationId)) {
                educationRepository.deleteById(educationId);
                return ResponseEntity.ok("Success");
            } else {
                throw new IllegalArgumentException("Education with ID " + educationId + " does not exist");
            }
        }
        return ResponseEntity.notFound().build();
    }
}
