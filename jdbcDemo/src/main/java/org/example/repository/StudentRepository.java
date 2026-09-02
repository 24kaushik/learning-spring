package org.example.repository;

import org.example.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/student_db";
    String user = "root";
    String password = "kaushik";

    Connection connection;

    public StudentRepository() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public void createStudent(Student student) {
        try {

            String query = """
                    INSERT INTO students (name, email, age) VALUES (?, ?, ?)
                    """;

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getAge());

            int result = statement.executeUpdate();

            System.out.println("Number of rows affected: " + result);

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String name, String email, int age) {
        try {


            String query = """
                    UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?""";


            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, age);
            statement.setInt(4, id);

            int result = statement.executeUpdate();

            System.out.println("Number of rows affected: " + result);


        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        try {
            String query = """
                    DELETE FROM students WHERE id = ?
                    """;

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int result = statement.executeUpdate();

            System.out.println("Number of rows affected: " + result);


        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public void getAllStudent() {
        try {

            Statement statement = connection.createStatement();

            String query = "SELECT id, name, email, age FROM students";

            ResultSet result = statement.executeQuery(query);

            List<Student> students = new ArrayList<>();

            while (result.next()) {
                Student currentStudent = new Student(result.getLong("id"), result.getString("name"), result.getString("email"), result.getInt("age"));
                students.add(currentStudent);
            }

            students.forEach(System.out::println);


        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
