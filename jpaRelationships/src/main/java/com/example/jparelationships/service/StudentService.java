package com.example.jparelationships.service;

import com.example.jparelationships.model.Department;
import com.example.jparelationships.model.Student;
import com.example.jparelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentService departmentService;

    public StudentService(StudentRepository studentRepository, DepartmentService departmentService) {
        this.studentRepository = studentRepository;
        this.departmentService = departmentService;
    }

    @Transactional
    public void createStudent(Student student, Long departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        if (department == null) {
            throw new IllegalArgumentException("Department with ID " + departmentId + " not found");
        }
        student.setDepartment(department);
        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String departmentName) {
        Department department = departmentService.getDepartmentByName(departmentName);
        if (department == null) {
            department = new Department();
            department.setName(departmentName);
            departmentService.createDepartment(department);
        }
        student.setDepartment(department);
        studentRepository.save(student);
    }

}
