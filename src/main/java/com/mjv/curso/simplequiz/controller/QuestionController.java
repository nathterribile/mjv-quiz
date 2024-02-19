package com.mjv.curso.simplequiz.controller;

import com.mjv.curso.simplequiz.dto.QuestionDTO;
import com.mjv.curso.simplequiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDTO questionDTO) {
        try {
            questionService.addQuestion(questionDTO);
            return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding question: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        List<QuestionDTO> questionList = questionService.getAllQuestions();
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }

    @GetMapping("/list-by-theme/{theme}")
    public ResponseEntity<List<QuestionDTO>> getQuestionsByTheme(@PathVariable String theme) {
        List<QuestionDTO> questionList = questionService.getQuestionsByTheme(theme);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }

    @GetMapping("/list-themes")
    public ResponseEntity<List<String>> getAllThemes() {
        List<String> themeList = questionService.getAllThemes();
        return new ResponseEntity<>(themeList, HttpStatus.OK);
    }

    @PostMapping("/remove/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        try {
            questionService.deleteQuestionById(id);
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting question: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
