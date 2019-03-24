package com.m2sdeveloper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.m2sdeveloper.login.TodoService;

@Controller
public class TodoController {
  
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		System.out.println("Test : In Todo Controller");
		model.addAttribute("todos", todoService.retriveTodo("m2sdeveloper"));
		return "list-todos";
	}
}
