package com.quizlery.service.Inter;

import com.quizlery.dto.QuizDto;

import java.util.List;

public interface QuizServiceInter {

    QuizDto findQuizById(Integer id);
    QuizDto findQuizByTitle(String title);
    List<QuizDto> findAll();
    QuizDto createQuiz(QuizDto quizDto);
    QuizDto updateQuiz(QuizDto quizDto, Integer id);
    void deleteQuizById(Integer id);
}
