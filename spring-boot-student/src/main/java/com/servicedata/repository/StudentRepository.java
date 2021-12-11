package com.servicedata.repository;

import com.servicedata.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByFirstNameAndLastName(String firstName, String lastName);
    Student findByEmail(String email);
}
