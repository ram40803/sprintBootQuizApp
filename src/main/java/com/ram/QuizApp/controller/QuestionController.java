package com.ram.QuizApp.controller;

import com.ram.QuizApp.model.Question;
import com.ram.QuizApp.model.Response;
import com.ram.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionSer;

    @GetMapping("getAll")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionSer.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionCategory(@PathVariable String category){
        return questionSer.getQuesctionCategory(category);
    }



    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionSer.addQuestion(question);
    }

    @GetMapping("sampledata")
    public void SampleDataLoader(){
        // Science
        questionSer.addQuestion(new Question("What is the chemical symbol for water?", "O2", "H2O", "CO2", "H2", "H2O", "Easy", "Science"));
        questionSer.addQuestion(new Question("What part of the cell contains DNA?", "Cytoplasm", "Nucleus", "Ribosome", "Membrane", "Nucleus", "Medium", "Science"));
        questionSer.addQuestion(new Question("Which gas do plants absorb from the atmosphere?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen", "Carbon Dioxide", "Easy", "Science"));
        questionSer.addQuestion(new Question("What planet is known as the Red Planet?", "Venus", "Mars", "Jupiter", "Saturn", "Mars", "Easy", "Science"));
        questionSer.addQuestion(new Question("What is the speed of light?", "3x10^6 m/s", "3x10^8 m/s", "3x10^10 m/s", "3x10^4 m/s", "3x10^8 m/s", "Hard", "Science"));

        // History
        questionSer.addQuestion(new Question("Who was the first President of the United States?", "Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams", "George Washington", "Easy", "History"));
        questionSer.addQuestion(new Question("In what year did World War II end?", "1940", "1945", "1939", "1950", "1945", "Medium", "History"));
        questionSer.addQuestion(new Question("Which empire built the Colosseum?", "Greek", "Roman", "Byzantine", "Ottoman", "Roman", "Medium", "History"));
        questionSer.addQuestion(new Question("Who was the leader of Nazi Germany?", "Stalin", "Churchill", "Hitler", "Roosevelt", "Hitler", "Easy", "History"));
        questionSer.addQuestion(new Question("Where was the Declaration of Independence signed?", "Boston", "Philadelphia", "New York", "Washington D.C.", "Philadelphia", "Medium", "History"));

        // Mathematics
        questionSer.addQuestion(new Question("What is 7 x 8?", "54", "56", "64", "58", "56", "Easy", "Mathematics"));
        questionSer.addQuestion(new Question("What is the square root of 144?", "12", "14", "11", "13", "12", "Easy", "Mathematics"));
        questionSer.addQuestion(new Question("What is the value of pi (π) approximately?", "2.14", "3.14", "3.41", "4.13", "3.14", "Easy", "Mathematics"));
        questionSer.addQuestion(new Question("Solve: 2x + 3 = 7", "x=3", "x=2", "x=1", "x=4", "x=2", "Medium", "Mathematics"));
        questionSer.addQuestion(new Question("What is 10 to the power of 3?", "100", "1000", "10000", "100000", "1000", "Easy", "Mathematics"));

        // Geography
        questionSer.addQuestion(new Question("What is the capital of France?", "Berlin", "Madrid", "Rome", "Paris", "Paris", "Easy", "Geography"));
        questionSer.addQuestion(new Question("Which is the largest continent?", "Africa", "Asia", "Europe", "Australia", "Asia", "Medium", "Geography"));
        questionSer.addQuestion(new Question("Which river is the longest in the world?", "Amazon", "Nile", "Yangtze", "Mississippi", "Nile", "Hard", "Geography"));
        questionSer.addQuestion(new Question("In which country is the Great Barrier Reef?", "USA", "India", "Australia", "Brazil", "Australia", "Medium", "Geography"));
        questionSer.addQuestion(new Question("Mount Everest is part of which mountain range?", "Andes", "Rockies", "Himalayas", "Alps", "Himalayas", "Medium", "Geography"));

    }
}
