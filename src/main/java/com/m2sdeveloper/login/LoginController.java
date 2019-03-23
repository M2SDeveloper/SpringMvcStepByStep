package com.m2sdeveloper.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage()
	{
		System.out.println("Hello World");
		return "welcome";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String name,@RequestParam String password)
	{
		System.out.println("Hello World");
		model.put("name", name);
		model.put("password",password);
		return "welcome";
	}
}
