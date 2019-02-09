package com.example.saein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String loginMain(Model model) {
		model.addAttribute("name", "spting_name_tests");
		return "login";
	}
	
}
