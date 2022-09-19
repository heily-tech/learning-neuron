package com.newlearn.jpa.newlearn.repository;

import com.newlearn.jpa.newlearn.entity.Answer;
import com.newlearn.jpa.newlearn.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Optional<Answer> findByAnswerNum(Integer answerNum);
}
