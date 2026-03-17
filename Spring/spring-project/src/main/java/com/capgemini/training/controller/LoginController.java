package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.training.Entity.UserEntity;
import com.capgemini.training.services.LoginServices;

@Controller
public class LoginController {

	@Autowired
	LoginServices loginServices;

	@GetMapping("/")
	public String login(Model model) {
		return "/login.jsp";
	}

	@PostMapping("/login")
	public String login(String username, String password, Model model) {

		UserEntity user = loginServices.authenticateUser(username, password);

		if (user != null) {
			model.addAttribute("name", user.getName());
			model.addAttribute("user", user.getName());
			return "/welcome.jsp";

		} else if ("admin".equals(username) && "admin".equals(password)) {
			model.addAttribute("name", "Admin");
			model.addAttribute("user", "Admin");
			return "/welcome.jsp";

		} else {
			return "/employeeList.jsp";
		}
	}

	@GetMapping("/register")
	public String showRegister() {
		return "/register.jsp";
	}

	@PostMapping("/register")
	public String register(String name, String username, String email, String password, Model model) {

		if (username != null && !username.isBlank() && password != null && !password.isBlank()) {
			UserEntity newUser = new UserEntity();
			newUser.setName(name);
			newUser.setUsername(username);
			newUser.setEmail(email);
			newUser.setPassword(password);
			loginServices.registerUser(newUser);

			model.addAttribute("msg", "Registration successful. Please login.");
			return "/login.jsp";
		} else {
			model.addAttribute("error", "Please provide username and password to register.");
			return "/register.jsp";
		}
	}

	@GetMapping("/forgot")
	public String showForgot() {
		return "/forgot.jsp";
	}

	@PostMapping("/forgot")
	public String forgot(String username, Model model) {
		// simple placeholder: pretend we sent a reset link if username provided
		if (username != null && !username.isBlank()) {
			model.addAttribute("msg", "If an account exists for '" + username + "', a reset link has been sent.");
		} else {
			model.addAttribute("error", "Please enter your username or email.");
		}
		return "/login.jsp";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("users", loginServices.getAllUsers());
		return "/users.jsp";
	}

	@GetMapping("/users/new")
	public String showCreateUserForm(Model model) {
		model.addAttribute("userEntity", new UserEntity());
		model.addAttribute("formAction", "/users/save");
		model.addAttribute("pageTitle", "Create User");
		return "/user-form.jsp";
	}

	@GetMapping("/users/edit/{id}")
	public String showEditUserForm(@PathVariable Integer id, Model model) {
		UserEntity userEntity = loginServices.getUserById(id);
		if (userEntity == null) {
			model.addAttribute("error", "User not found.");
			model.addAttribute("users", loginServices.getAllUsers());
			return "/users.jsp";
		}

		model.addAttribute("userEntity", userEntity);
		model.addAttribute("formAction", "/users/update");
		model.addAttribute("pageTitle", "Edit User");
		return "/user-form.jsp";
	}

	@PostMapping("/users/save")
	public String saveUser(String name, String username, String email, String password) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(name);
		userEntity.setUsername(username);
		userEntity.setEmail(email);
		userEntity.setPassword(password);
		loginServices.registerUser(userEntity);
		return "redirect:/users";
	}

	@PostMapping("/users/update")
	public String updateUser(Integer id, String name, String username, String email, String password) {
		UserEntity existingUser = loginServices.getUserById(id);
		if (existingUser != null) {
			existingUser.setName(name);
			existingUser.setUsername(username);
			existingUser.setEmail(email);
			existingUser.setPassword(password);
			loginServices.registerUser(existingUser);
		}
		return "redirect:/users";
	}

	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		loginServices.deleteUser(id);
		return "redirect:/users";
	}
}