package org.example.springcrud.controller;

import org.example.springcrud.dto.StudentRequestDTO;
import org.example.springcrud.entity.Student;
import org.example.springcrud.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        Student createdStudent = studentService.createStudent(studentRequestDTO);
        return ResponseEntity
                .status(201)
                .body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable Long id){
        Student student = studentService.getStudentByID(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping()
    public ResponseEntity<List<Student>> get() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudentSoftly(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudentSoft(id);
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
