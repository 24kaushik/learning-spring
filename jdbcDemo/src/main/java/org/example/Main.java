package org.example;

import org.example.entity.Student;
import org.example.repository.StudentRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static void main() {
        StudentRepository studentRepository = new StudentRepository();

//      studentRepository.createStudent(new Student(4, "Hitesh", "hitesh@email.com", 18));
//      studentRepository.updateStudent(2, "David", "david@gmail.com", 22);
        studentRepository.getAllStudent();

    }
}
