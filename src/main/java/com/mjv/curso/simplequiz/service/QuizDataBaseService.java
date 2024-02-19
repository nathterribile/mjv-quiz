package com.mjv.curso.simplequiz.service;

import com.mjv.curso.simplequiz.model.Question;
import com.mjv.curso.simplequiz.model.QuestionAlternative;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizDataBaseService {

    public ArrayList<Question> showAllQuestions(){
        ArrayList<Question> questionsList = StaticDataBaseOnlyForTests.staticDataBaseWithHardcode();
        return questionsList;
    }

    public ArrayList<Question> findByTheme(String theme){
        ArrayList<Question> filteredQuestionsList = new ArrayList<>();
        ArrayList<Question> allQuestions = StaticDataBaseOnlyForTests.staticDataBaseWithHardcode();

        for (Question question : allQuestions) {
            if (question.getTheme().equalsIgnoreCase(theme)) {
                filteredQuestionsList.add(question);
            }
        }
        return filteredQuestionsList;
    }


    public ArrayList<Question> findByTheme(ArrayList<Question> allQuestions, String theme){
        ArrayList<Question> filteredQuestionsList = new ArrayList<>();

        for (Question question : allQuestions) {
            if (question.getTheme().equalsIgnoreCase(theme)) {
                filteredQuestionsList.add(question);
            }
        }
        return filteredQuestionsList;
    }

    public Question findQuestionById(Long questionId){
        ArrayList<Question> dataBaseQuestions = StaticDataBaseOnlyForTests.staticDataBaseWithHardcode();
        for(Question question:dataBaseQuestions){
            if(question.getId().equals(questionId)) {
                return question;
            }
        }
        return null;
    }

    public List<QuestionAlternative> findQuestionAlternativesByQuestionId(Long questionId){
        ArrayList<Question> dataBaseQuestions = StaticDataBaseOnlyForTests.staticDataBaseWithHardcode();
        for(Question question:dataBaseQuestions){
            if(question.getId().equals(questionId)) {
                return question.getQuestionAlternativeArrayList();
            }
        }
        return null;
    }


}
