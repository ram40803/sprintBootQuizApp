package com.ram.QuizApp.service;

import com.ram.QuizApp.model.Question;
import com.ram.QuizApp.model.Response;
import com.ram.QuizApp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRe;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionRe.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getQuesctionCategory(String category) {
        try{
            return new ResponseEntity<>(questionRe.findByCategory(category), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionRe.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        }
    }
}
