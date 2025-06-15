package com.question.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.question.Services.QuestionServices;
import com.question.entities.Question;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
	
	
	@Autowired
	private QuestionServices questionServices;
	
	

	//create question
	@PostMapping("/")
	public ResponseEntity<Question>  createQuestion ( @RequestBody Question question){
		
     	return new  ResponseEntity<>(this.questionServices.createQuestion(question),HttpStatus.CREATED);
		
	}

	//get All question
	@GetMapping("/")
	public ResponseEntity<List<Question>> getAllQuestion(){
		
		return ResponseEntity.ok( this.questionServices.getAllQuestion());
	}
	
	
	// get question by id
	
	@GetMapping("/{questionId}")
	public ResponseEntity<Question> getQuestionById(@PathVariable Integer questionId){
		
		return ResponseEntity.ok(this.questionServices.getQuestionById(questionId));
	}
	
	
	
	
}
