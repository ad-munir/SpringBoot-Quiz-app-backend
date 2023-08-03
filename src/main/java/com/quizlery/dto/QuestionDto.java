package com.quizlery.dto;

import com.quizlery.model.Option;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QuestionDto {

    private String text;
    private Integer correctOption;
    private List<Option> options;
}
