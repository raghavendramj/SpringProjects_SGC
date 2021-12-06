package com.learning.repository;

import com.learning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    List<Department> findByName(String name);
}
