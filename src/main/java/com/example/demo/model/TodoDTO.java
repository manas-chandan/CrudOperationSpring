package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class TodoDTO {

	@Id
	private String _id;
	private String name;
	private int roll;
//	private Boolean competed;
//	private Date createdAt;
//	private Date updatedAt;
	
	 @Override
	    public String toString() {
	        return "TodoDTO{" +
	               "id= " + _id + ", " +
	               "name= " + name + '\'' +
	               "roll= " + roll + '\'' +
	               // Include other fields as needed
	               '}';
	    }
}

