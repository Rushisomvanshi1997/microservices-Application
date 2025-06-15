package com.question.Services.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.Services.QuestionServices;
import com.question.entities.Question;
import com.question.repo.QuestionRepo;

@Service
public class QuestionServiceImple  implements QuestionServices{

	@Autowired
	private QuestionRepo  questionRepo;
	
	@Override
	public Question createQuestion(Question question) {
		
		return  this.questionRepo.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		
		return  this.questionRepo.findAll();
	}

	@Override
	public Question getQuestionById(Integer questionId) {
	
		return  this.questionRepo.findById(questionId).orElseThrow(()-> new RuntimeException(" Question not Found.!!"));
	}

}
