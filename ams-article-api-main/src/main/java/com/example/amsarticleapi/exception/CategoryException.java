package com.example.amsarticleapi.exception;

public class CategoryException extends Exception {

	String msg;

	public CategoryException() {
		super();
	}

	public CategoryException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
	
	

}
