package com.quiz.Services.imple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.Services.QuizServices;
import com.quiz.entities.Quiz;
import com.quiz.repo.QuizRepository;

@Service
public class QuizServiceImple implements QuizServices {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz add(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getqiz() {
		
		return this.quizRepository.findAll();
	}

	@Override
	public Quiz getById(Integer id) {
		// TODO Auto
		return this.quizRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Quiz not found.!!"));
	}

}
