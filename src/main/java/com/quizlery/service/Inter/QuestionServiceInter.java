package com.quizlery.service.Inter;

import com.quizlery.dto.QuestionDto;

import java.util.List;

public interface QuestionServiceInter {

    QuestionDto findQuestionById(Integer id);
    List<QuestionDto> findAll();
    QuestionDto createQuestion(QuestionDto questionDto);
    QuestionDto updateQuestion(QuestionDto questionDto, Integer id);
    void deleteQuestionById(Integer id);
}
