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

import com.example.onlineportal.entity.Admin;
import com.example.onlineportal.exceptions.AdminNotFoundException;

import com.example.onlineportal.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminRepository adminrepo;

	@GetMapping
	public Iterable<Admin> getAdmin() {
		return adminrepo.findAll();
	}

	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable("id") Integer id) {
		Optional<Admin> opt = adminrepo.findById(id);
		if (opt.isEmpty()) {
			throw new AdminNotFoundException(id);
		}
		return opt.get();
	}

	@PostMapping
	public Admin create(@RequestBody Admin admin) {
		return adminrepo.save(admin);
	}

	@PutMapping
	public Admin update(@RequestBody Admin admin) {
		return adminrepo.save(admin);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		adminrepo.deleteById(id);
	}
}
