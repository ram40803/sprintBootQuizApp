package com.ram.QuizApp.service;

import com.ram.QuizApp.model.Quesction;
import com.ram.QuizApp.repo.QuesctionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesctionService {

    @Autowired
    private QuesctionRepo repo;

    public List<Quesction> getAllQuestions() {
        return repo.findAll();
    }

    public List<Quesction> getQuesctionCategory(String category) {
        return repo.findByCategory(category);
    }

    public void addQuesction(Quesction quesction) {
        repo.save(quesction);
    }
}
