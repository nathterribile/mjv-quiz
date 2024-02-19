package com.mjv.curso.simplequiz.service;

import com.mjv.curso.simplequiz.builder.QuestionAlternativeMapper;
import com.mjv.curso.simplequiz.builder.QuestionMapper;
import com.mjv.curso.simplequiz.dto.QuestionAlternativeDTO;
import com.mjv.curso.simplequiz.dto.QuestionDTO;
import com.mjv.curso.simplequiz.model.Question;
import com.mjv.curso.simplequiz.model.QuestionAlternative;
import com.mjv.curso.simplequiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private final QuestionAlternativeMapper questionAlternativeMapper;

    public QuestionService(QuestionAlternativeMapper questionAlternativeMapper) {
        this.questionAlternativeMapper = questionAlternativeMapper;
    }


    public void addQuestion(QuestionDTO questionDTO) {
        // 1. Salvar as alternativas na tabela question_alternatives e associar à questão
        List<QuestionAlternative> alternatives = new ArrayList<>();
        for (QuestionAlternativeDTO alternativeDTO : questionDTO.getQuestionAlternativeDTOArrayList()) {
            QuestionAlternative alternativeEntity = questionAlternativeMapper.toEntity(alternativeDTO);
            alternatives.add(alternativeEntity);
        }

        // 2. Associar as alternativas à questão
        Question questionEntity = questionMapper.toEntity(questionDTO);
        questionEntity.setQuestionAlternativeArrayList(new ArrayList<>(alternatives));

        // 3. Salvar a questão na tabela questions
        questionRepository.save(questionEntity);

    }


    public List<QuestionDTO> getAllQuestions() {
        List<Question> questionList = questionRepository.findAll();
        return questionMapper.toListDTO(questionList);
    }

    public List<QuestionDTO> getQuestionsByTheme(String theme) {
        List<Question> questionList = questionRepository.findByTheme(theme);
        return questionMapper.toListDTO(questionList);
    }

    public List<String> getAllThemes() {
        return questionRepository.findAllDistinctThemes();
    }


    public void deleteQuestionById(Long id) {
        Question question = questionRepository.findQuestionById(id);
        questionRepository.deleteById(id);
        if ((question != null)) {
            questionMapper.toDTO(question);
        }
    }
}
