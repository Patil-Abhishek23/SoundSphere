package com.kodnest.soundsphere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {

	@GetMapping("/login")
	public String login(HttpSession session) {
		session.invalidate();
		return "login";
	}

	      @GetMapping("/registration")
	public String registration(HttpSession session) {
		session.invalidate();
		return "registration";
	}

}