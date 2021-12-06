package com.learning.service.impl;

import com.learning.entity.Department;
import com.learning.repository.DepartmentRepository;
import com.learning.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {

        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        if(optionalDepartment.isPresent()){
            return optionalDepartment.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Department> getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public Department deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).get();
        departmentRepository.delete(department);
        return department;
    }
}
