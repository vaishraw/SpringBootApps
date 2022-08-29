package com.example.demo.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@DataJpaTest
public class Tests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void returnUserFromName() {
		User testUser = new User();
		testUser.setName("newTest");
		testUser.setEmail("test@email.com");
		testUser.setPassword("testpw");
		entityManager.persist(testUser);
		entityManager.flush();

		User found = userRepository.findByName(testUser.getName());

		assertEquals(found.getName(), testUser.getName());
	}

	@Test
	public void passwordNotNull() {

		Iterable<User> users = userRepository.findAll();
		for (User u : users)
			assertNotNull(u.getPassword());
	}

	@Test
	public void nameNotNull() {

		Iterable<User> users = userRepository.findAll();
		for (User u : users)
			assertNotNull(u.getName());
	}

	@Test
	public void emailNotNull() {

		Iterable<User> users = userRepository.findAll();
		for (User u : users)
			assertNotNull(u.getEmail());
	}

}
