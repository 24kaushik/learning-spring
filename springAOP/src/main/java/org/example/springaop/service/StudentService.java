package org.example.springaop.service;

import org.example.springaop.annotation.TrackExecutionTime;
import org.example.springaop.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime
    public String getAllStudents() throws InterruptedException {
        Thread.sleep((int) (Math.random() * 1000));
        System.out.println("Getting all students");
        return "Get all Students";
    }

    public Student createStudent(Student student) {
        System.out.println("Creating student: " + student.getName());
        return student;
    }
}
