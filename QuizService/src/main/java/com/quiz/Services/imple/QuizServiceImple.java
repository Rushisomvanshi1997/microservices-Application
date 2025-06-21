package com.quiz.Services.imple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quiz.Services.QuestionClient;
import com.quiz.Services.QuizServices;
import com.quiz.entities.Quiz;
import com.quiz.repo.QuizRepository;

@Service
public class QuizServiceImple implements QuizServices {
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;
	
	//@Autowired
	//private RestTemplate restTemplate;

	@Override
	public Quiz add(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}
	

	@Override
	public List<Quiz> getqiz() {
		
      List<Quiz>  quizes = this.quizRepository.findAll();
      
		
		  List<Quiz> newquizesList = quizes.stream().map(quiz -> {
		  
		  quiz.setListOfQuestion(questionClient.getQuestionOFQuiz(quiz.getId()));
		  
		  return quiz;
		  
		  }).collect(Collectors.toList());
		 
      
      
      
      
		return newquizesList;
   }

	@Override
	public Quiz getById(Integer id) {
	
   Quiz  quiz =	this.quizRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Quiz not found.!!"));
 // ArrayList forobj = restTemplate.getForObject("http://localhost:9092/api/question/quizId/"+id, Arrays+.class);
   
   
	quiz.setListOfQuestion(questionClient.getQuestionOFQuiz(id));
	
	return  quiz;
	}

}
