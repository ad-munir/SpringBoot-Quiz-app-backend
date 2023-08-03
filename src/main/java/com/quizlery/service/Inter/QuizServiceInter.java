package com.quizlery.service.Inter;

import com.quizlery.dto.QuizDto;
import com.quizlery.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizServiceInter {

    QuizDto findQuizById(Integer id);
    QuizDto findQuizByTitle(String title);
    List<QuizDto> findAll();
    QuizDto createQuiz(QuizDto quizDto);
    QuizDto updateQuiz(QuizDto quizDto, Integer id);
    void deleteQuizById(Integer id);

    List<QuizDto> findByDifficultyLevel(String difficultyLevel);

    List<String> findAllCategories();
}
