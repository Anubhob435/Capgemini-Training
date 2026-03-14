package com.capgemini.Springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginControl {
	@GetMapping({"/", "/login"})
	public String loginPage() {
		return "login";
	}


	@PostMapping("/login")
	public String handleLogin(@RequestParam String username,
							 @RequestParam String password,
							 Model model) {
		if ("admin".equals(username) && "admin".equals(password)) {
			model.addAttribute("username", username);
			return "home";
		}

		model.addAttribute("error", "Invalid username or password");
		model.addAttribute("username", username);
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register"; // resolves to register.jsp
	}
	
	@PostMapping("/register")
	public String handleRegister(@RequestParam String username,
								 @RequestParam String email,
								 @RequestParam String password,
								 Model model) {
		model.addAttribute("message", "Registered as " + username + " (" + email + ")");
		return "register";
	}
	
	@GetMapping("/forget-password")
	@ResponseBody
	public String forgetPassword() {
		return "Password reset flow";
	}
}