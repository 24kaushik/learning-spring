package org.example.springinterceptors.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    public ResponseEntity<String> getStudent() {
        System.out.println("Inside StudentController.getStudent()");
        return ResponseEntity.ok("Hello from StudentController");
    }

    @PostMapping
    public ResponseEntity<String> createStudent() {
        System.out.println("Inside StudentController.createStudent()");
        return ResponseEntity.ok("Student created");
    }
}
