package com.m2sdeveloper.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.m2sdeveloper.login.TodoService;
import com.m2sdeveloper.model.Todo;

@Controller
@SessionAttributes("name")
public class TodoController {
  
	@Autowired
	private TodoService todoService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		System.out.println("Test : In Todo Controller");
		String user=(String) model.get("name");
		model.addAttribute("todos", todoService.retriveTodos(user));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showTodoPage(ModelMap model)
	{
		model.addAttribute("todo", new Todo());
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo,BindingResult result)
	{
		System.out.println("Inside add todo method");
		if(result.hasErrors())
			return "todo";
		
		todoService.addTodo((String) model.get("name"),todo.getDesc(), new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) 
	{
		model.addAttribute("todo",todoService.retriveTodo(id));
		return "todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo,BindingResult result)
	{
		System.out.println("Inside update todo method");
		if(result.hasErrors())
			return "todo";
		
		todo.setUser((String) model.get("name"));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id)
	{
		System.out.println("Test : Inside delete Todo method");
		todoService.removeTodo(id);
		
		return "redirect:/list-todos";
	}
}
