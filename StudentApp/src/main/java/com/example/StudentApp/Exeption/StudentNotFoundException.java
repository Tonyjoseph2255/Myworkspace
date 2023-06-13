package com.example.StudentApp.Exeption;

public class StudentNotFoundException extends RuntimeException{
	public StudentNotFoundException(String message) {
		super(message);
	}

}
