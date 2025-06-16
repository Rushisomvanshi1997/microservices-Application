package com.quiz.Services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.Question;

@FeignClient(url="http://localhost:9092", value="Question-Client")
public interface QuestionClient {
	
	
	@GetMapping("/api/question/quizId/{quizId}")
	List<Question>  getQuestionOFQuiz(@PathVariable Integer quizId);
	
	
	
}
