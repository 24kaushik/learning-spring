package org.example.springaop.controller;

import org.example.springaop.dto.Student;
import org.example.springaop.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<String> getAllStudents() throws InterruptedException {
        studentService.getAllStudents();
        return ResponseEntity.ok("Get all Students");
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student st = studentService.createStudent(student);
        return ResponseEntity.status(201).body(st);
    }
}
