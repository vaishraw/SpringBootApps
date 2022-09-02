package com.example.userquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userquiz.entity.ScoreCompare;

import com.example.userquiz.repository.ScoreCompareRepository;

@RestController
@RequestMapping("/scorecard")
public class ScoreCompareController {

	@Autowired
	ScoreCompareRepository repo;

	@GetMapping
	public Iterable<ScoreCompare> getUser() {
		return repo.findAll();
	}

	@PostMapping
	public ScoreCompare create(@RequestBody ScoreCompare sc) {
		return repo.save(sc);
	}
}
