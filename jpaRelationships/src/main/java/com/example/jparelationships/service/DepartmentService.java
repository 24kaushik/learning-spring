package com.example.jparelationships.service;

import com.example.jparelationships.model.Department;
import com.example.jparelationships.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName);
    }
}

