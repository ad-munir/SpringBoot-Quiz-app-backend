package com.quizlery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "quiz_attempt")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long timeTaken;
    private Date date;
    private Integer score;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Client client;

}
