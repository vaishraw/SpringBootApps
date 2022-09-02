package com.example.onlineportal.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.onlineportal.entity.Admin;

import com.example.onlineportal.exceptions.AdminNotFoundException;
import com.example.onlineportal.repository.AdminRepository;

@Controller
@RequestMapping("/verifyadmin")
public class AdminVerifyController {

	@Autowired
	private AdminRepository repo;

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/loginverify", method = RequestMethod.POST)
	@ResponseBody
	public String ValidateAdmin(HttpServletRequest request) {

		String username = request.getParameter("adminname");
		String password = request.getParameter("password");
		Optional<Admin> optproduct = repo.findByAdminnameAndPassword(username, password);
		if (optproduct.isEmpty()) {
			throw new AdminNotFoundException(username, password);
		}

		return "Login Successful";
	}

}