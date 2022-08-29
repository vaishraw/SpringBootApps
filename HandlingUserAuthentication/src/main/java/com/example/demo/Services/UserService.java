package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> GetAllUsers() {
		return userRepository.findAll();
	}

	public User GetUserByName(String name) {
		User foundUser = userRepository.findByName(name);
		return foundUser;
	}

	public String GetUserById(int id) {
		Optional<User> foundUser = userRepository.findById(id);

		if (!foundUser.isPresent()) {
			throw new UserNotFoundException(id);
		}

		return (foundUser.get().toString());
	}

	public void UpdateUser(User usertoUpdate) {
		userRepository.save(usertoUpdate);
	}

}
