package com.learning.controller;

import com.learning.entity.Department;
import com.learning.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
//        try{
//            Department departmentById = departmentService.getDepartmentById(departmentId);
//            return ResponseEntity.status(HttpStatus.OK).body(departmentById.toString());
//        } catch (NoSuchElementException e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }

    }

    @GetMapping("/searchDepartment")
    public List<Department> searchDepartmentByName(@RequestParam("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/departments/{id}")
    public Department deleteDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }

}
