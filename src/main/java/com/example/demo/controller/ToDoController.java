package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TodoDTO;
import com.example.demo.repository.ToDoRepository;

@RestController
public class ToDoController {

	@Autowired
	private ToDoRepository todoRepo;
	
	@GetMapping("/todos")
	public ResponseEntity<?> getAllTodo(){
		List<TodoDTO> todos=todoRepo.findAll();
		System.out.println(todos);
		for (TodoDTO td : todos) {
			System.out.println(td);
		}
		if(todos.size()>0) {
			return new ResponseEntity<List<TodoDTO>>(todos,HttpStatus.OK);
//			return todos;
		}else {
			return new ResponseEntity<>("No todos avaiable",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/todos")
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO todo){
		
		System.out.println(todo);
		try {
			todoRepo.save(todo);
			return new ResponseEntity<TodoDTO>(todo,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping	
	public String Hello(){
		return "hello world";
	}
}

