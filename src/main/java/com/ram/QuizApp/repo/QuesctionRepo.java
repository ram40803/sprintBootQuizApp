package com.ram.QuizApp.repo;

import com.ram.QuizApp.model.Quesction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuesctionRepo extends JpaRepository<Quesction, Integer> {
    List<Quesction> findByCategory(String category);
}
