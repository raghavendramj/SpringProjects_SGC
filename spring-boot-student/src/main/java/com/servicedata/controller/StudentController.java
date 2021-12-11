package com.servicedata.controller;

import com.servicedata.entity.Student;
import com.servicedata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/searchByName")
    public Student getStuentByName(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName){
        return  studentService.getStudentByName(firstName, lastName);
    }

    @GetMapping("/searchByEmail")
    public Student getStudentByEmail(@RequestParam("email") String email){
        return studentService.getStudentByEmail(email);
    }


    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId,
                                 @RequestBody Student student){
        return studentService.udpateStudent(studentId, student);
    }


    @DeleteMapping("/students/{id}")
    public Student deleteStudent(@PathVariable("id") Long studentId){
        return studentService.deleteStudent(studentId);
    }
}
