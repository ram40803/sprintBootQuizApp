package com.ram.QuizApp.controller;

import com.ram.QuizApp.model.QuestionWrapper;
import com.ram.QuizApp.model.Response;
import com.ram.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizSer;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        quizSer.createQuiz(category, numQ, title);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizSer.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizSer.calculateResult(id, responses);
    }

}
