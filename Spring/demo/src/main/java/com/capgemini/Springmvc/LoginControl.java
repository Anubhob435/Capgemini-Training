package com.capgemini.Springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class LoginControl {
	@GetMapping("/login")
	@ResponseBody
	public String validate() {
		return "Login Successfull";
	}
}
