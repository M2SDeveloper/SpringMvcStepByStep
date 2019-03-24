package com.m2sdeveloper.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.m2sdeveloper.login.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
  
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		System.out.println("Test : In Todo Controller");
		String user=(String) model.get("name");
		model.addAttribute("todos", todoService.retriveTodo(user));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showTodoPage()
	{
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc)
	{
		System.out.println("Test :model Name "+(String) model.get("name"));
		todoService.addTodo((String) model.get("name"), desc, new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
}
