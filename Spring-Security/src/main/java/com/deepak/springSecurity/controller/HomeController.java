package com.deepak.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

	@GetMapping("home")
	public String home(HttpServletRequest req) {
		return "Hello world " + req.getSession().getId();
	}

	@GetMapping("about")
	public String about(HttpServletRequest req) {
		return "Deepak " + req.getSession().getId();
	}

}
