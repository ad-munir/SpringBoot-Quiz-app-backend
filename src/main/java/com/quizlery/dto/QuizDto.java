package com.quizlery.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QuizDto {

    private String title;

    private String description;

    private Date createdAt;
}
