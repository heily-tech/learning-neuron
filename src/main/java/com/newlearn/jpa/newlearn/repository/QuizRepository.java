package com.newlearn.jpa.newlearn.repository;

import com.newlearn.jpa.newlearn.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    Optional<Quiz> findByQuizNum(Integer quizNum);
}
