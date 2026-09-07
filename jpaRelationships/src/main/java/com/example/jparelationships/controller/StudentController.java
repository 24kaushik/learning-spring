package com.example.jparelationships.controller;

import com.example.jparelationships.model.Student;
import com.example.jparelationships.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam Long deptId) {
        studentService.createStudent(student, deptId);
        return ResponseEntity.ok("Student created successfully");
    }

    @PostMapping("/withDeptName")
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam String deptName) {
        studentService.createStudent(student, deptName);
        return ResponseEntity.ok("Student created successfully");
    }

}
