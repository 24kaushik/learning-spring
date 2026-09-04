package com.example.springhibernate.service;

import com.example.springhibernate.entity.Student;
import com.example.springhibernate.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    public List<Student> getAllStudents() {
//        return studentRepository.getAllStudents();
//    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

//    public boolean updateStudent(long id, String name, String email, int age) {
//        return studentRepository.updateStudent(id, name, email, age);
//    }

    @Transactional
    public boolean deleteStudent(long id) {
        studentRepository.remove(studentRepository.findById(id));
        return true;
    }
}
