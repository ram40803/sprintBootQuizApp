package com.ram.QuizApp.controller;

import com.ram.QuizApp.model.Quesction;
import com.ram.QuizApp.service.QuesctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quesction")
public class QuesctionController {

    @Autowired
    private QuesctionService quesctionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Quesction>> getAllQuestions(){
        return quesctionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Quesction>> getQuesctionCategory(@PathVariable String category){
        return quesctionService.getQuesctionCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuesction(@RequestBody Quesction quesction){
        return quesctionService.addQuesction(quesction);
    }
}
