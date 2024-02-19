package com.mjv.curso.simplequiz;

import com.mjv.curso.simplequiz.dto.PlayerDTO;
import com.mjv.curso.simplequiz.model.Question;
import com.mjv.curso.simplequiz.model.User;

import com.mjv.curso.simplequiz.service.GameplayService;
import com.mjv.curso.simplequiz.service.QuizDataBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class SimpleQuizApplicationTests {

	@Autowired
	private QuizDataBaseService quizDataBaseService;
	@Autowired
	private GameplayService gamePlayService;

	@Test
	void contextLoads() {
		//showMyQuizDataBase
		User user = new User("Dhionson","Dhionson Plaster Moreira", 30);



	}

	private void showMyQuizDataBase(){
		ArrayList<Question> allQuestionsList = quizDataBaseService.showAllQuestions();

		System.out.println("Meus dados do quiz : " + allQuestionsList);
		System.out.println("Pause - \n\n");

		System.out.println("Mostrando apenas o tema Cinema : \n" + quizDataBaseService.findByTheme(allQuestionsList, "Cinema"));
	}

	/*public static void main(String[] args) {
		QuizDataBaseService quizDataBaseService = new QuizDataBaseService();

		ArrayList<Question> allQuestionsList = quizDataBaseService.showAllQuestions();

		System.out.println("Meus dados do quiz : " + allQuestionsList);
		System.out.println("Pause - \n\n");

		System.out.println("Mostrando apenas o tema Cinema : \n" + quizDataBaseService.findByTheme(allQuestionsList, "Cinema"));
	}*/



}
