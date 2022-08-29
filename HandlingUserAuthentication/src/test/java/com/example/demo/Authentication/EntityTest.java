package com.example.demo.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.demo.Entity.User;

public class EntityTest {

	@Test
	public void getAndSetPassword() {
		User testUser = new User();

		testUser.setPassword("mypassword");
		assertEquals(testUser.getPassword(), "mypassword");
	}

	@Test
	public void getAndSetName() {
		User testUser = new User();

		testUser.setName("joe");
		assertEquals(testUser.getName(), "joe");
	}

	@Test
	public void getAndSetEmail() {
		User testUser = new User();

		testUser.setEmail("joe@email.com");
		assertEquals(testUser.getEmail(), "joe@email.com");
	}

	@Test
	public void checkToString() {
		User testUser = new User();

		assertNotNull(testUser.toString());
	}

	@Test
	public void checkConstructor() {
		User testUser = new User("joe", "joe@email.com", "123");

		User checkUser = new User();
		checkUser.setName("joe");
		checkUser.setEmail("joe@email.com");
		checkUser.setPassword("123");

		assertEquals(testUser.getName(), checkUser.getName());
		assertEquals(testUser.getEmail(), checkUser.getEmail());
		assertEquals(testUser.getPassword(), checkUser.getPassword());
	}

	@Test
	public void testDefaultConstructor() {
		User testUser = new User();

		assertNotNull(testUser);
	}
}
