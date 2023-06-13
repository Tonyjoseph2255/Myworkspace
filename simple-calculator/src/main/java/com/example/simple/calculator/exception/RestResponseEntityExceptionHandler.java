package com.example.simple.calculator.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(value = { ConstraintViolationException.class })
//	protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
//			WebRequest request) {
//		String bodyOfResponse = ex.getLocalizedMessage();
//		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//	}
	@ExceptionHandler(value= {NumberFormatException.class})
	protected ResponseEntity<Object>handleCalcException(NumberFormatException ex,WebRequest request){
		String bodyofResponse=ex.getLocalizedMessage();
		return handleExceptionInternal(ex, bodyofResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		
	}
	
	@ExceptionHandler(value= {CalcException.class})
	protected ResponseEntity<Object>handleCalcException(CalcException ex,WebRequest request){
		String bodyofResponse=ex.getLocalizedMessage();
		return handleExceptionInternal(ex, bodyofResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		
	}
	
	@ExceptionHandler(value= {Exception.class})
	protected ResponseEntity<Object>handleCalcException(Exception ex,WebRequest request){
		String bodyofResponse=ex.getLocalizedMessage();
		return handleExceptionInternal(ex, bodyofResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
		
	}

}
