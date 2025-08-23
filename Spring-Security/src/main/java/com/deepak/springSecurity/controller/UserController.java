package com.deepak.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.springSecurity.model.User;
import com.deepak.springSecurity.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("register")
	public User register(@RequestBody User user) {
		return service.saveUser(user);
	}

}
