package com.example.onlineportal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlineportal.entity.Quiz;
import com.example.onlineportal.exceptions.QuizNotFoundException;
import com.example.onlineportal.repository.QuizRepository;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizRepository quizrepo;

	@GetMapping
	public Iterable<Quiz> getQuiz() {
		return quizrepo.findAll();
	}

	@GetMapping("/{id}")
	public Quiz getQuiz(@PathVariable("id") Integer id) {
		Optional<Quiz> opt = quizrepo.findById(id);
		if (opt.isEmpty()) {
			throw new QuizNotFoundException(id);
		}
		return opt.get();
	}

	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizrepo.save(quiz);
	}

	@PutMapping
	public Quiz update(@RequestBody Quiz quiz) {
		return quizrepo.save(quiz);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		quizrepo.deleteById(id);
	}
}
