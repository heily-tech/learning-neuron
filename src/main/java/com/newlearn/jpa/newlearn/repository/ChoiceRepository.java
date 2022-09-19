package com.newlearn.jpa.newlearn.repository;

import com.newlearn.jpa.newlearn.entity.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
    Optional<Choice> findByChoiceNum(Integer choiceNum);
}