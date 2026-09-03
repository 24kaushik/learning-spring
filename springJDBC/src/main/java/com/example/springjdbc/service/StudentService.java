package com.example.springjdbc.service;

import com.example.springjdbc.entity.Student;
import com.example.springjdbc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(long id) {
        return studentRepository.getStudentById(id);
    }

    public boolean createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    public boolean updateStudent(long id, String name, String email, int age) {
        return studentRepository.updateStudent(id, name, email, age);
    }

    public boolean deleteStudent(long id) {
        return studentRepository.deleteStudent(id);
    }
}
