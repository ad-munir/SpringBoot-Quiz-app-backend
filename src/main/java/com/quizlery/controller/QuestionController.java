package com.quizlery.controller;

import com.quizlery.dto.QuestionDto;
import com.quizlery.service.QuestionService;
import com.quizlery.service.questionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<QuestionDto> findAll() {
        return questionService.findAll();
    }s

    @PostMapping
    public QuestionDto createQuestion(@RequestBody QuestionDto question){
        return questionService.createQuestion(question);
    }

    @GetMapping("/id/{id}")
    public QuestionDto findQuestionById(@PathVariable Integer id) {
        return questionService.findQuestionById(id);
    }

    @PutMapping("/id/{id}")
    public QuestionDto updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable Integer id) {
        return questionService.updateQuestion(questionDto, id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteQuestionById(@PathVariable Integer id) {
        questionService.deleteQuestionById(id);
    }
}
