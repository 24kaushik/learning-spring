package com.example.springhibernate.controller;

import com.example.springhibernate.entity.Student;
import com.example.springhibernate.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping
//    public ResponseEntity<List<Student>> getStudents() {
//        return ResponseEntity.ok(studentService.getAllStudents());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

//    @PatchMapping
//    public ResponseEntity<String> updateStudent(@RequestParam Long id, @RequestParam String name, @RequestParam String email, @RequestParam int age) {
//        boolean isUpdated = studentService.updateStudent(id, name, email, age);
//
//        if (isUpdated) {
//            return ResponseEntity.ok("Student updated successfully");
//        } else {
//            return ResponseEntity.status(500).body("Failed to update student");
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean isDeleted = studentService.deleteStudent(id);

        if (isDeleted) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to delete student");
        }
    }

}
