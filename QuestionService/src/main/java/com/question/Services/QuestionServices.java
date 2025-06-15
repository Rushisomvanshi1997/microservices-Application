package com.question.Services;


import java.util.List;

import com.question.entities.Question;

public interface QuestionServices {
	
	
	//create
	Question createQuestion(Question question) ;
		
	//getAll
	List<Question> getAllQuestion();
	
	//getByIdu
	Question getQuestionById(Integer questionId);

}
