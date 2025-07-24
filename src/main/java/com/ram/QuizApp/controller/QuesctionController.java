package com.ram.QuizApp.controller;

import com.ram.QuizApp.model.Quesction;
import com.ram.QuizApp.service.QuesctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quesction")
public class QuesctionController {

    @Autowired
    private QuesctionService quesctionService;

    @GetMapping("allQuestions")
    public List<Quesction> getAllQuestions(){
        return quesctionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Quesction> getQuesctionCategory(@PathVariable String category){
        return quesctionService.getQuesctionCategory(category);
    }

    @PostMapping("add")
    public void addQuesction(@RequestBody Quesction quesction){
        quesctionService.addQuesction(quesction);
    }
}
