package com.example.persistence;

import com.example.model.User;

public interface Local {
	
	public User consultaUser(User user) throws Exception;
	
}
