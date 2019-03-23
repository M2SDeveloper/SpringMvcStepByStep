package com.m2sdeveloper.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String name, String password)
	{
		return name.equalsIgnoreCase("mangesh") && password.equalsIgnoreCase("dummy");
	}
}
