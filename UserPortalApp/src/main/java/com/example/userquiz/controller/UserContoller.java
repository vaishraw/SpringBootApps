package com.example.userquiz.controller;

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

import com.example.userquiz.entity.User;
import com.example.userquiz.exceptions.UserNotFoundException;
import com.example.userquiz.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserContoller {

	@Autowired
	UserRepository userrepo;

	@GetMapping
	public Iterable<User> getUser() {
		return userrepo.findAll();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		Optional<User> opt = userrepo.findById(id);
		if (opt.isEmpty()) {
			throw new UserNotFoundException(id);
		}
		return opt.get();
	}

	@PostMapping
	public User create(@RequestBody User user) {
		return userrepo.save(user);
	}

	@PutMapping
	public User update(@RequestBody User user) {
		return userrepo.save(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userrepo.deleteById(id);
	}
}
