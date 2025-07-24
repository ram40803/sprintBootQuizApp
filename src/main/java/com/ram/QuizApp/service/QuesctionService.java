package com.ram.QuizApp.service;

import com.ram.QuizApp.model.Quesction;
import com.ram.QuizApp.repo.QuesctionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuesctionService {

    @Autowired
    private QuesctionRepo repo;

    public ResponseEntity<List<Quesction>> getAllQuestions() {
        try{
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Quesction>> getQuesctionCategory(String category) {
        try{
            return new ResponseEntity<>(repo.findByCategory(category), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuesction(Quesction quesction) {
        try{
            repo.save(quesction);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        }
    }
}
