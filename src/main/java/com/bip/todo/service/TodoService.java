package com.bip.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bip.todo.entity.Todo;
import com.bip.todo.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
// adding a todo
	
	public Todo addTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
// get all todos
	
	public List<Todo> getTodos(){
		return todoRepository.findAll();
	}
	
// get a todo by Status (completed or incomplete)
	public List<Todo> getTodoByStatus(String taskStatus){
		return todoRepository.findByTaskStatus(taskStatus);
	}
	
// get a todo by Id	
	
	public Todo getTodoById(Integer taskId) {
		return this.todoRepository.getById(taskId);
	}
	
// update a todo by
	
	public String updateTodo(Todo todo) {
    	Todo t = todoRepository.findById(todo.getTaskId()).get();
    	if(t != null) {
    		t.setTaskDesc(todo.getTaskDesc());
    		t.setTaskStatus(todo.getTaskStatus());
    	}
    	t = todoRepository.save(t);
    	return "updated successfully";
    }
	
	
// delete a todo by Id	
	
	public boolean deleteTodo(Integer taskId) {
		boolean status = false;
		todoRepository.deleteById(taskId);
		if(this.getTodoById(taskId) == null) {
			status  = true;
		}
		return status;
	}
	
}
