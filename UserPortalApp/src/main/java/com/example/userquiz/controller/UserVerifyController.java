package com.example.userquiz.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.userquiz.entity.User;
import com.example.userquiz.exceptions.UserNotFoundException;
import com.example.userquiz.repository.UserRepository;

@Controller
@RequestMapping("/verifyuser")
public class UserVerifyController {

	@Autowired
	UserRepository repo;

	@RequestMapping("/userLogin")
	public String showLoginPage() {
		return "Userlogin";
	}

	@RequestMapping(value = "/userloginverify", method = RequestMethod.POST)
	@ResponseBody
	public String ValidateAdmin(HttpServletRequest request) {

		String username = request.getParameter("name");
		String password = request.getParameter("password");
		Optional<User> optproduct = repo.findByNameAndPassword(username, password);
		if (optproduct.isEmpty()) {
			throw new UserNotFoundException(username, password);
		}

		return "Login Successful";
	}

}
