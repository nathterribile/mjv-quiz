package com.mjv.curso.simplequiz.service;

import com.mjv.curso.simplequiz.model.Question;
import com.mjv.curso.simplequiz.model.QuestionAlternative;

import java.util.ArrayList;

public class StaticDataBaseOnlyForTests {

    public static ArrayList<Question> staticDataBaseWithHardcode(){
        ArrayList<Question> questionsList = new ArrayList<>();


        // Pergunta 1
        ArrayList<QuestionAlternative> alternativesOne = new ArrayList<>();
        alternativesOne.add(new QuestionAlternative(1L,"A","O Senhor dos Anéis: O Retorno do Rei", true));
        alternativesOne.add(new QuestionAlternative(2L,"B", "Titanic", false));
        alternativesOne.add(new QuestionAlternative(3L,"C", "Ben-Hur", false));
        alternativesOne.add(new QuestionAlternative(4L,"D","Gandhi", false));
        alternativesOne.add(new QuestionAlternative(5L,"E","Avatar", false));
        alternativesOne.add(new QuestionAlternative(6L,"F","Forrest Gump", false));
        alternativesOne.add(new QuestionAlternative(7L,"G","Pulp Fiction", false));
        alternativesOne.add(new QuestionAlternative(8L,"H","Gladiador", false));
        questionsList.add(new Question(1L, "Cinema", "Qual é o filme mais premiado da história do Oscar?", "O Senhor dos Anéis: O Retorno do Rei", 1L, alternativesOne));

        return questionsList;
    }

}
