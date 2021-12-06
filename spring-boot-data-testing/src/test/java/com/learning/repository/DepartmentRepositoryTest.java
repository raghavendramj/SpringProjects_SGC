package com.learning.repository;

import com.learning.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void whenFindById_ThenReturnMatchingDepartment(){
        Optional<Department> optionalDepartment = departmentRepository.findById(22l);
        if(optionalDepartment.isPresent()){
            Department department = optionalDepartment.get();
            assertEquals(department.getName(), "CSE");
        } else {
            System.out.println("Is Not Present");
            assertFalse(optionalDepartment.isPresent());
        }
    }

    @Test
    public void whenFindByName_ThenReturnMatchingNameDepartments(){
        String departmentName = "ECE";

        List<Department> departments = departmentRepository.findByName(departmentName);
        if(departments.size() >= 1){
            Department department = departments.get(0);
            assertEquals(department.getName(), departmentName);
        } else {
            System.out.println("No matching departments with name : "+ departmentName);
            assertTrue(departments.size() == 0);
        }
    }
}