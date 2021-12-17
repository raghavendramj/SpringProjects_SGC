package com.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {

    @GetMapping("/welcome/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Welcome to the application, " + name;
    }
}
