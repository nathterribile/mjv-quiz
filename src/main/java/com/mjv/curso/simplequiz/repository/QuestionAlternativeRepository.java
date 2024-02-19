package com.mjv.curso.simplequiz.repository;

import com.mjv.curso.simplequiz.model.QuestionAlternative;
import com.mjv.curso.simplequiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAlternativeRepository extends JpaRepository<QuestionAlternative, Long> {
    List<QuestionAlternative> findByQuestionId(Long questionId);
}


