package com.mjv.curso.simplequiz.service;

import com.mjv.curso.simplequiz.builder.QuestionAlternativeMapper;
import com.mjv.curso.simplequiz.dto.QuestionAlternativeDTO;
import com.mjv.curso.simplequiz.model.QuestionAlternative;
import com.mjv.curso.simplequiz.repository.QuestionAlternativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAlternativeService {

    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;

    @Autowired
    private QuestionAlternativeMapper questionAlternativeMapper;

    public List<QuestionAlternativeDTO> getAllQuestionAlternatives() {
        List<QuestionAlternative> questionAlternatives = questionAlternativeRepository.findAll();
        return questionAlternativeMapper.toListDTO(questionAlternatives);
    }

    public List<QuestionAlternativeDTO> getAlternativesByQuestion(Long questionId) {
        List<QuestionAlternative> questionAlternatives = questionAlternativeRepository.findByQuestionId(questionId);
        return questionAlternativeMapper.toListDTO(questionAlternatives);
    }
}



