package com.example.jparelationships.repository;

import com.example.jparelationships.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department) {
        entityManager.persist(department);
    }

    public Department findById(Long id) {
        return entityManager.find(Department.class, id);
    }

    public Department findByName(String departmentName) {
        String query = "SELECT d FROM Department d WHERE d.name = :name";
        return entityManager.createQuery(query, Department.class)
                .setParameter("name", departmentName)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
