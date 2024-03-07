package com.company.loggingpractical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.loggingpractical.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
