package com.example.springjdbc.repository;

import com.example.springjdbc.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final StudentRowMapper studentRowMapper = new StudentRowMapper();

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createStudent(Student student) {

        String query = """
                INSERT INTO students (name, email, age) VALUES (?, ?, ?)
                """;

        int rowAffected = jdbcTemplate.update(query, student.getName(), student.getEmail(), student.getAge());

        System.out.println("Number of rows affected: " + rowAffected);

        return rowAffected > 0;

    }

    public boolean updateStudent(long id, String name, String email, int age) {

        String query = """
                UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?
                """;


        int result = jdbcTemplate.update(query, name, email, age, id);

        System.out.println("Number of rows affected: " + result);

        return result > 0;

    }

    public boolean deleteStudent(long id) {

        String query = """
                DELETE FROM students WHERE id = ?
                """;

        int result = jdbcTemplate.update(query, id);

        System.out.println("Number of rows affected: " + result);

        return result > 0;

    }

    public List<Student> getAllStudents() {

        String query = "SELECT id, name, email, age FROM students";

        List<Student> students = jdbcTemplate.query(query, studentRowMapper);

        students.forEach(System.out::println);

        return students;
    }

    public Student getStudentById(long id) {

        String query = "SELECT id, name, email, age FROM students WHERE id = ?";

        Student student = jdbcTemplate.queryForObject(query, studentRowMapper, id);

        System.out.println(student);

        return student;
    }

}
