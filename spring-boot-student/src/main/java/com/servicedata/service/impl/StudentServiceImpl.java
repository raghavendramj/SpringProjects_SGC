package com.servicedata.service.impl;

import com.servicedata.entity.Student;
import com.servicedata.repository.StudentRepository;
import com.servicedata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent())
            return optionalStudent.get();
        else
            return null;
    }

    @Override
    public Student getStudentByName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student udpateStudent(Long id, Student student) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent())
            return studentRepository.save(student);
        else
            return null;
    }

    @Override
    public Student deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student deletedStudent = optionalStudent.get();
            studentRepository.delete(deletedStudent);
            return deletedStudent;
        } else

            return null;
    }
}
