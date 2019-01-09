package com.example.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping(value ="user/")
public class UserController {

	
	@Autowired
	private UserService userService = null;

	@RequestMapping(path = "login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user) {
		try {
			return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
		} catch (Exception e) {
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}

	}
	
	
	  @GetMapping("/hid/{name}")
	  public String hi(@PathVariable String name) {
	  	return "His " + name;
	  }
	
}
