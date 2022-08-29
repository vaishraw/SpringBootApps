package com.example.demo.Authentication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.Controller.LoginController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WebTest {

	@Autowired
	private LoginController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void checkLoginPage() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().is4xxClientError());
	}

	@Test
	public void checkUsersPage() throws Exception {
		this.mockMvc.perform(get("/allusers")).andDo(print()).andExpect(status().isOk());
	}
}
