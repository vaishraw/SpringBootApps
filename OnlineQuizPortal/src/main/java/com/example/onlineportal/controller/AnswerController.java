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

import com.example.onlineportal.entity.Answer;

import com.example.onlineportal.repository.AnswerRepository;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	AnswerRepository ansrepo;

	@GetMapping
	public Iterable<Answer> getQuiz() {
		return ansrepo.findAll();
	}

	@GetMapping("/{id}")
	public String getQues(@PathVariable("id") Integer id) {
		Optional<Answer> opt = ansrepo.findById(id);
		if (opt.isEmpty()) {
			return "Answer not found";
		}
		return opt.get().toString();
	}

	@PostMapping
	public Answer create(@RequestBody Answer ans) {
		return ansrepo.save(ans);
	}

	@PutMapping
	public Answer update(@RequestBody Answer ans) {
		return ansrepo.save(ans);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		ansrepo.deleteById(id);
	}

}
