package com.servicedata.service;


import com.servicedata.entity.Student;

import java.util.List;

public interface StudentService {

    //CREATE
    Student saveStudent(Student student);

    //READ
    List<Student> getStudents();
    Student  getStudentById(Long Id);
    Student getStudentByName(String firstName, String lastName);
    Student getStudentByEmail(String email);

    //UPDATE
    Student udpateStudent(Long id, Student student);

    //DELETE
    Student deleteStudent(Long id);
}
