package org.example.springcrud.service;

import org.example.springcrud.dto.StudentRequestDTO;
import org.example.springcrud.entity.Student;
import org.example.springcrud.repository.StudentRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(@NonNull StudentRequestDTO studentRequestDTO) {
        Student student = mapToEntity(studentRequestDTO);
        Student studentResp = studentRepository.save(student);
        return mapToDTO(studentResp);
    }

    public Student updateStudent(Long id, Student newStudent) {
        Student student = studentRepository.findByIdAndDeletedFalse(id).orElse(null);
        if (student == null) return null;

        if (newStudent.getName() != null) student.setName(newStudent.getName());
        if (newStudent.getEmail() != null) student.setEmail(newStudent.getEmail());
        if (newStudent.getAge() != null) student.setAge(newStudent.getAge());
        if (newStudent.getRollNo() != null) student.setRollNo(newStudent.getRollNo());
        if (newStudent.getSubject() != null) student.setSubject(newStudent.getSubject());
        student.setDeleted(false);

        studentRepository.save(student);

        return student;
    }

    public Student getStudentByID(Long id) {
        return studentRepository.findByIdAndDeletedFalse(id).orElse(null);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAllByDeletedIsFalse();
    }

    public boolean deleteStudentSoft(Long id) {
        Student student = studentRepository.findByIdAndDeletedFalse(id).orElse(null);

        if (student == null) return false;

        student.setDeleted(true);
        studentRepository.save(student);

        return true;
    }

    public Student mapToEntity(StudentRequestDTO studentRequestDTO){
        Student student = new Student();

        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setEmail(studentRequestDTO.getEmail());
        student.setRollNo(studentRequestDTO.getRollNo());
        student.setSubject(studentRequestDTO.getSubject());

        return student;

    }
}
