package com.bagudu.fleetApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("/index")
	public String goHome() {
		return "index";
	}
	
	@GetMapping("/accessdenied")
	public String accessDenied() {
		return "access_denied";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/error")
	public String errorPage() {
		return "pages-error-404";
	}

}
