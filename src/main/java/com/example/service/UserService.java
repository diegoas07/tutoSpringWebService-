package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.persistence.LocalImp;

@Component
public class UserService {

	@Autowired
	private LocalImp localImp;
	
	public User login(User user) throws Exception {
		return localImp.consultaUser(user);
	}
	
}
