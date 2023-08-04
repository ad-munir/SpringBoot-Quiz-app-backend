package com.quizlery.dto;

import com.quizlery.model.QuizAttempt;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private String password;

    private List<QuizAttempt> attempts;
}
