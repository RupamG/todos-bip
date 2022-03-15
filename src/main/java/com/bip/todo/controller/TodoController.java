package com.bip.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bip.todo.entity.Todo;
import com.bip.todo.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private TodoService todoService;
	@PostMapping({"/"})
    public ResponseEntity<?> addTodo(@RequestBody Todo todo){
    	
    	Todo todoObj=this.todoService.addTodo(todo);
    	if(todoObj!=null)
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body(todoObj);
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todo could not be created");
    	    	
    }
	
	@GetMapping({"/"})
    public List<Todo> getAllTodos(){
    	return this.todoService.getTodos();
    }
	
	@GetMapping({"/getById/{taskId}"})
    public Todo getTodoById(@PathVariable("taskId") 
    Integer taskId){
    	return this.todoService.getTodoById(taskId);
    }
	
	@GetMapping({"/getByStatus/{taskStatus}"})
	public List<Todo> getTodoByStatus(@PathVariable String taskStatus){
		return this.todoService.getTodoByStatus(taskStatus);
	}
	
	@PutMapping({"/"})
	public String updateTodo(@RequestBody Todo todo) {
		return this.todoService.updateTodo(todo);
	}
	
	@DeleteMapping({"/{taskId}"})
    public ResponseEntity<?> deleteTodoById(@PathVariable("taskId") 
    Integer taskId){
    	boolean status= this.todoService.deleteTodo(taskId);
    	if(status)
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Todo with "
    				+ "Id"+taskId+"deleted");
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todo with "
    				+ "Id"+taskId+ "Not Deleted");
    	
    }
	
	
}
