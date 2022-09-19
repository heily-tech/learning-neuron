package com.newlearn.jpa.newlearn.repository;

import com.newlearn.jpa.newlearn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByStudentNum(Integer studentNum);
}
