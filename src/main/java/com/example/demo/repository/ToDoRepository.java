package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.TodoDTO;

public interface ToDoRepository extends MongoRepository<TodoDTO, String> {

}

