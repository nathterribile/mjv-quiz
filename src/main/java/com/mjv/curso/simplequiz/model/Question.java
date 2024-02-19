package com.mjv.curso.simplequiz.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "question")
    private String question;

    @Column(name = "response")
    private String response;

    @Column(name = "correct_question_alternative_id")
    private Long correctQuestionAlternativeID;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<QuestionAlternative> questionAlternativeArrayList;



    public Question(){

    }

    public Question(String theme, String question, String response) {
        this.theme = theme;
        this.question = question;
        this.response = response;
    }

    public Question(String theme, String question, String response, ArrayList<QuestionAlternative> questionAlternativeArrayList) {
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    public Question(Long id, String theme, String question, String response, ArrayList<QuestionAlternative> questionAlternativeArrayList) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    public Question(Long id, String theme, String question, String response, Long correctQuestionAlternativeID, ArrayList<QuestionAlternative> questionAlternativeArrayList) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.correctQuestionAlternativeID = correctQuestionAlternativeID;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Long getCorrectQuestionAlternativeID() {
        return correctQuestionAlternativeID;
    }

    public void setCorrectQuestionAlternativeID(Long correctQuestionAlternativeID) {
        this.correctQuestionAlternativeID = correctQuestionAlternativeID;
    }

    public List<QuestionAlternative> getQuestionAlternativeArrayList() {
        return questionAlternativeArrayList;
    }

    public void setQuestionAlternativeArrayList(ArrayList<QuestionAlternative> questionAlternativeArrayList) {
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    @Override
    public String toString() {
        return  "\n\n" +
                "id = " + id +
                "\nTheme = " + theme +
                "\nQuestion = " + question +
                "\nResponse = " + response +
                "\nCorrect Question id = " + correctQuestionAlternativeID;
    }


}