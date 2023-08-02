package com.quizlery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "quizzes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

    //private List<String> questions;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;
}
