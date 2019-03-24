package com.m2sdeveloper.login;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.m2sdeveloper.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "m2sdeveloper", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "m2sdeveloper", "Learn Spring boot", new Date(), false));
		todos.add(new Todo(3, "Mahendra", "Learn Hibernate", new Date(), false));
	}

	public List<Todo> retriveTodo(String user) {
		List<Todo> filterTodo = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filterTodo.add(todo);
		}
		return filterTodo;
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public void removeTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id)
				iterator.remove();
		}
	}
}
