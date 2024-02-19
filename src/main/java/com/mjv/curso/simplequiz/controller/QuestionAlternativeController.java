package com.mjv.curso.simplequiz.controller;

import com.mjv.curso.simplequiz.dto.QuestionAlternativeDTO;

import com.mjv.curso.simplequiz.service.QuestionAlternativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question-alternatives")
public class QuestionAlternativeController {

    @Autowired
    private QuestionAlternativeService questionAlternativeService;

    @GetMapping
    public List<QuestionAlternativeDTO> getAllQuestionAlternatives() {
        return questionAlternativeService.getAllQuestionAlternatives();
    }

    @GetMapping("/by-question/{questionId}")
    public List<QuestionAlternativeDTO> getAlternativesByQuestion(@PathVariable Long questionId) {
        return questionAlternativeService.getAlternativesByQuestion(questionId);
    }
}


