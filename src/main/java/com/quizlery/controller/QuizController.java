package com.quizlery.controller;

import com.quizlery.dto.QuizDto;
import com.quizlery.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public List<QuizDto> findAll() {
        return quizService.findAll();
    }

    @PostMapping
    public QuizDto createQuiz(@RequestBody QuizDto quiz){
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/id/{id}")
    public QuizDto findQuizById(@PathVariable Integer id) {
        return quizService.findQuizById(id);
    }

    @GetMapping("/title/{title}")
    public QuizDto findQuizByTitle(@PathVariable String title) {
        return quizService.findQuizByTitle(title);
    }

    @PutMapping("/id/{id}")
    public QuizDto updateQuiz(@RequestBody QuizDto quizDto, @PathVariable Integer id) {
        return quizService.updateQuiz(quizDto, id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteQuizById(@PathVariable Integer id) {
        quizService.deleteQuizById(id);
    }

    @GetMapping("/level/{level}")
    public List<QuizDto> findByDifficultyLevel(@PathVariable String level) {
        return quizService.findByDifficultyLevel(level);
    }

    @GetMapping("/categories")
    public List<String> findAllCategories() {
        return quizService.findAllCategories();
    }
}
