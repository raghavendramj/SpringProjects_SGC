package com.learning;

import com.learning.entity.Department;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTesting {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    @LocalServerPort
    private int port;

    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

    @Test
    public void testRetreivingTheDepartment() throws Exception {

        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Department> response =
                restTemplate.exchange(createURLWithPort("/departments/2"), HttpMethod.GET, httpEntity, Department.class);

        Department departmentResponse = response.getBody();
        Assertions.assertEquals("CSE", departmentResponse.getName());
    }

    @Test
    public void saveDepartment


}
