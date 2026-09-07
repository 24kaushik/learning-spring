package com.example.jparelationships.controller;

import com.example.jparelationships.model.Department;
import com.example.jparelationships.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Department created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            return ResponseEntity.ok("Department found: " + department.getName());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
