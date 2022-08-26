package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.FeedbackService;

@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackService fservice;
	
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}

}
