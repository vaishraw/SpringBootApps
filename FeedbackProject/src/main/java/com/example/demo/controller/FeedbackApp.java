package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Feedback;
import com.example.demo.service.FeedbackService;

@RestController
public class FeedbackApp {
	
	@Autowired
	private FeedbackService fservice;
	
	@PostMapping("/feedback")
	public String userRegister(@RequestParam("name") String name,  @RequestParam("email") String email , @RequestParam("feedback1") String feedback1) {
	Feedback f = new Feedback(name, email,feedback1);
	boolean data= fservice.addFeedback(f);
	if(data) {
		return "Feedback added succesfully!";
	}
	else {
		return "Unable to add the feedback";
	}
		
	}

}
