package com.learning.service.impl;

import com.learning.entity.Department;
import com.learning.repository.DepartmentRepository;
import com.learning.service.DepartmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;


@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        //Department(id=2, name=CSE, address=Mysore, code=CSE-07)
        //departmentRepository.findById(2l) => new Department(2l, "CSE", "Mysore", "CSE-07");
        Department department = new Department(2l, "CSE", "Mysore", "CSE-07");
        Mockito.when(departmentRepository.findById(2l)).thenReturn(Optional.of(department));
    }

    @Test
    public void whenValidDepartmentId_theDeraprtmentShouldBeFound() {
        Department department = departmentService.getDepartmentById(2l);
        Assertions.assertEquals(department.getName(), "CSE");
    }

    @Test
    public void whenInValidDepartmentId_thenNotFound(){
        Department department = departmentService.getDepartmentById(20l);
        Assertions.assertNull(department);
    }


}