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

import com.example.onlineportal.entity.Questions;
import com.example.onlineportal.exceptions.QuestionNotFoundException;
import com.example.onlineportal.repository.QuestionRepository;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionRepository quesrepo;

	@GetMapping
	public Iterable<Questions> getQuiz() {
		return quesrepo.findAll();
	}

	@GetMapping("/{id}")
	public Questions getQues(@PathVariable("id") Integer id) {
		Optional<Questions> opt = quesrepo.findById(id);
		if (opt.isEmpty()) {
			throw new QuestionNotFoundException(id);
		}
		return opt.get();
	}

	@PostMapping
	public Questions create(@RequestBody Questions ques) {
		return quesrepo.save(ques);
	}

	@PutMapping
	public Questions update(@RequestBody Questions ques) {
		return quesrepo.save(ques);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		quesrepo.deleteById(id);
	}

}
