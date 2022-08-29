package com.example.demo.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.Repository.UserRepository;

@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@GetMapping(value = "/")
	public String showIndexPage(ModelMap model) {
		return "<html>\n" + "<body >\n" + "	<div class=\"center\">\n" + "		<h1>User Login Page</h1>\n" + "		\n"
				+ "		<h2 class=\"hello-title\">Welcome</h2>\n" + "		\n"
				+ "		<a href=\"/allusers\">View all users</a>\n" + "		<br><br>\n"
				+ "     <form method=\"get\" action=\"login\">\n" + "			<br><h3>Login below:</h3>\n"
				+ "			<input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Name\" required>\n"
				+ "			<input type=\"text\" id=\"email\" name=\"email\" placeholder=\"Email\" required>\n"
				+ "			<input type=\"text\" id=\"password\" name=\"password\" placeholder=\"Password\" required>	\n"
				+ "			<input type=\"submit\" value=\"Enter\" />\n" + "		</form>" + "	</div>\n"
				+ "</body>\n" + "</html>";
	}

	@GetMapping("/login")
	public String showLogin(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, ModelMap map) {
		User u = new User(name, email, password);
		userRepository.save(u);

		return "<html>\n"

				+ "<body >\n" + "	<div class=\"center\">\n" + "		<h1>Logged In</h1>\n" + "		\n"
				+ "		<h2 class=\"hello-title\">Successfully Added Your Information</h2>\n" + "	</div>\n"
				+ "</body>\n" + "</html>";
	}

	@GetMapping("/allusers")
	public @ResponseBody String getAllFeedbacks() {

		Iterable<User> allUser = userRepository.findAll();
		return "<html>\n" + "<body >\n" + "	<div class=\"center\">\n" + "<h1>Feedback Table</h1>\n" + allUser.toString()
				+ "	</div>\n" + "</body>\n" + "</html>";
	}

	@PostMapping("/login")
	public String submitLogin(@RequestParam String username, @RequestParam String password) {

		return "Success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getOneProduct(@PathVariable("id") int id) {
		Optional<User> optProduct = userRepository.findById(id);
		if (optProduct.isEmpty()) {
			throw new UserNotFoundException(id);
		}
		return optProduct.get().toString();
	}
}
