package com.example.simple.calculator.exception;

public class CalcException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public CalcException() {
		super();
	}

	public CalcException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
		this.msg = msg;
	}

}
