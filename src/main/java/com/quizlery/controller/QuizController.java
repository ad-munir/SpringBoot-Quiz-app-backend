package com.quizlery.controller;

import com.quizlery.model.Quiz;
import com.quizlery.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizRepo quizRepo;

    @GetMapping
    public List<Quiz> findAll() {
        return quizRepo.findAll();
    }

    @PostMapping
    public Quiz add(@RequestBody Quiz quiz){
        return quizRepo.save(quiz);
    }
}
