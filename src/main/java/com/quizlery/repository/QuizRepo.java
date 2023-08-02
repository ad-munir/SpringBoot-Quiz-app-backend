package com.quizlery.repository;

import com.quizlery.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
    Optional<Quiz> findByTitle(String title);
}
