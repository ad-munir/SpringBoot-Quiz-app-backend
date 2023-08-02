package com.quizlery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    private Integer id;

    private String text;
    //private List<String> options;
    //private Integer correctOption;


    @ManyToOne
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
    private List<Option> options;
}
