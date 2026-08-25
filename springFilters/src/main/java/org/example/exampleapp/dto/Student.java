package org.example.exampleapp.dto;

import java.util.List;

public class Student {
    long id;
    int roll_no;
    String name;
    int age;
    List<String> subjects;

    public Student(long id, int roll_no, String name, int age, List<String> subjects) {
        this.id = id;
        this.roll_no = roll_no;
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
