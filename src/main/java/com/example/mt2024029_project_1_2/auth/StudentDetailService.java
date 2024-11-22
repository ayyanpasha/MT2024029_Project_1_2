package com.example.mt2024029_project_1_2.auth;

import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String rollnumber) throws UsernameNotFoundException {
        Student student = studentRepository.findByRollNumber(rollnumber);
        if(student == null){
            throw new UsernameNotFoundException("Student 404");
        }
        return new StudentPrincipal(student);
    }
}
