package com.example.saein.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginMain(Model model) {
		model.addAttribute("name", "spting_name_tests");
		return "login";
	}
	
	@GetMapping("/secure/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession s = req.getSession();
		s.setAttribute("a", 111);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			
			new SecurityContextLogoutHandler()
			.logout(req, res, auth);
			req.getSession().invalidate();
			
		}
		
		return "redirect:/secure/welcome";
	}
	
}
