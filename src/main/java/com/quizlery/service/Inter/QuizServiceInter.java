package com.quizlery.service.Inter;

import com.quizlery.dto.QuizDto;
import com.quizlery.model.Quiz;

import java.util.List;

public interface QuizServiceInter {

    public QuizDto findQuizById(Integer id);
    public List<QuizDto> findAll();
    public QuizDto createQuiz(QuizDto quizDto);
    public QuizDto updateQuiz(QuizDto quizDto, Integer id);
    public void deleteQuiz(Integer id);
}
