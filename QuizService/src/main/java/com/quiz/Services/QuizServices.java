package com.quiz.Services;

import java.util.List;

import com.quiz.entities.Quiz;

public interface QuizServices {
	
	
	//create
	
    Quiz add(Quiz quiz);

	
	//update
    
    List<Quiz> getqiz();
    
	//findById
    
    Quiz getById (Integer id);
    

}
