package com.learning.service;

import com.learning.entity.Department;

import java.util.List;

public interface DepartmentService {

    //CREATE
    Department saveDepartment(Department department);

    //READ
    List<Department> getDepartments();
    Department getDepartmentById(Long id);
	List<Department> getDepartmentByName(String name);

	//UPDATE
    Department updateDepartment(Long id, Department department);

    //DELETE
    Department deleteDepartment(Long id);
}
