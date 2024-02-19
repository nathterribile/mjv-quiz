package com.mjv.curso.simplequiz.repository;

import com.mjv.curso.simplequiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTheme(String theme);


    @Query("SELECT DISTINCT q.theme FROM Question q")
    List<String> findAllDistinctThemes();

    Question findQuestionById(Long id);
}
