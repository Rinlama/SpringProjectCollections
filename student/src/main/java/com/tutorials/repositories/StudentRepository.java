package com.tutorials.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorials.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
