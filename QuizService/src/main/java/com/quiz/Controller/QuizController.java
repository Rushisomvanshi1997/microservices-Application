package com.quiz.Controller;
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

import com.quiz.Services.QuizServices;
import com.quiz.entities.Quiz;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
	
	@Autowired
	private QuizServices quizServices;
	
	//create post
	@PostMapping("/")
	public ResponseEntity<Quiz>  createQuize (@RequestBody Quiz quiz){
		
		return  new ResponseEntity<Quiz>( this.quizServices.add(quiz), HttpStatus.OK);
		
	} 
	
	// get all 	
	@GetMapping("/")
	public ResponseEntity<List<Quiz>> getAllPost (){
		
		return ResponseEntity.ok( this.quizServices.getqiz());
	}
	
	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> getPostById (@PathVariable Integer id){
		
		return ResponseEntity.ok( this.quizServices.getById(id));
		
	}
	
}
