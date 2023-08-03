package com.quizlery.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {

    private String questionText;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String correctOption;
}
