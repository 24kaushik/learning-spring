package org.example.exampleapp.service;

import org.example.exampleapp.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student) {
        System.out.println("Student created");
        return student;
    }
}
