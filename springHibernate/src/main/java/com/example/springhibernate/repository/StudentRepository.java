package com.example.springhibernate.repository;

import com.example.springhibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // create
    public void save(Student student) {
        entityManager.persist(student);
    }

    // read
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    // delete
    public void remove(Student student) {
        entityManager.remove(student);
    }


}
