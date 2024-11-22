package com.example.mt2024029_project_1_2.service;

import com.example.mt2024029_project_1_2.auth.StudentPrincipal;
import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public UserDetails loadUserByUsername(String rollnumber) throws UsernameNotFoundException {
        Student student = studentRepository.findByRollNumber(rollnumber);
        if(student == null) {
            throw new UsernameNotFoundException(rollnumber);
        }
        return new StudentPrincipal(student);
    }
}
