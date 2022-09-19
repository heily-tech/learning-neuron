package com.newlearn.jpa.newlearn.repository;

import com.newlearn.jpa.newlearn.entity.Essay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EssayRepository extends JpaRepository<Essay, Integer> {
    Optional<Essay> findByEssayNum(Integer essayNum);
}
