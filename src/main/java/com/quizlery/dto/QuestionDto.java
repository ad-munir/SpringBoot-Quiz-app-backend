package com.quizlery.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionDto {

    private String text;
    private Integer correctOption;
}
