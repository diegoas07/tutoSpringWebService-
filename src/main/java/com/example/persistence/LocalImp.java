package com.example.persistence;

import org.springframework.stereotype.Component;

import com.example.Security.SecurityToken;
import com.example.model.User;
@Component
public class LocalImp implements Local {

	@Override
	public User consultaUser(User user) throws Exception {
		String name = user.getName();
		String psw = user.getPsw();		
		if ("juan".equals(name) && "123".equals(psw)) {
			user.setToken(SecurityToken.getToken(user).getAccessToken());
			return user;
		}		
		throw new Exception("Inicio Session Invalido");
	}

	
	
}
