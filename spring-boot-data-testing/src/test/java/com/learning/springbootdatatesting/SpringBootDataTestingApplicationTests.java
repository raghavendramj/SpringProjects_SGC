package com.learning.springbootdatatesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootDataTestingApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_GetDepartment_WhenValidRequest() throws Exception {
        mockMvc.perform(get("/departments/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("CSE"))
                .andExpect(jsonPath("$.address").value("Mysore"))
                .andExpect(jsonPath("$.code").value("CSE-07"));
    }

    @Test
    public void shoud_Return_404_When_Department_NotFound() throws Exception {
        mockMvc.perform(get("/departments/25")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


}
