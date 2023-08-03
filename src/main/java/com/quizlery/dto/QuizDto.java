package com.quizlery.dto;

import com.quizlery.model.DifficultyLevel;
import lombok.Data;

import java.util.Date;

@Data
public class QuizDto {

    private String title;

    private String category;

    private String description;

    private DifficultyLevel difficultyLevel;

    private Date createdAt;
}
