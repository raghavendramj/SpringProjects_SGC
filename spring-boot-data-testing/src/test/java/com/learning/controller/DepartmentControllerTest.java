package com.learning.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.entity.Department;
import com.learning.service.DepartmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    //This is dummy object as  my response for all the cases.
    Department department;

    @Autowired
    DepartmentController departmentController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        department = new Department(2l, "CSE", "Mysore", "CSE-07");
    }

    @Test
    void testSaveDepartmentScenario() throws Exception {

        Department localDepartment = new Department(2l, "CSE", "Mysore", "CSE-07");
        Mockito.when(departmentService.saveDepartment(localDepartment)).thenReturn(department);

        String postResponse = "{ \"id\": 2, \"name\": \"CSE\", \"address\": \"Mysore\", \"code\": \"CSE-07\" }";

        MvcResult mvcResult = mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postResponse)).andExpect(status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.println("actualResponseFromPost -> "+ status);
        Assertions.assertEquals(status, 200);
    }
}