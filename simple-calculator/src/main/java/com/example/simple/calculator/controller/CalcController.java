package com.example.simple.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple.calculator.exception.CalcException;
import com.example.simple.calculator.service.CalcServices;



@RestController
public class CalcController {
	@Autowired
	CalcServices calcServices;
	@PostMapping("/Createcalc")
	public ResponseEntity<?>createCalc( @RequestBody CalcRequest calcRequest) throws CalcException{
		Integer result=calcServices.getResult(calcRequest);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
		 
		
	}
	

}
