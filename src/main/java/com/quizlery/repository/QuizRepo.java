package com.quizlery.repository;

import com.quizlery.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
    Optional<Quiz> findByTitle(String title);
    @Query(value = "SELECT DISTINCT q.category FROM Quizzes q", nativeQuery = true)
    List<String> findAllCategories();

    List<Quiz> findByDifficultyLevel(String difficultyLevel);
}
