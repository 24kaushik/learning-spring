package org.example.exampleapp.controller;

import org.example.exampleapp.dto.Student;
import org.example.exampleapp.service.StudentService;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        System.out.println(createdStudent.getName());
        System.out.println(createdStudent.getSubjects());
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping
    public ResponseEntity<String> getStudents() {
        return ResponseEntity.ok("List of students");
    }
}
