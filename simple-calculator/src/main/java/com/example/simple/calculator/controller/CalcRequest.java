package com.example.simple.calculator.controller;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document("student")
public class CalcRequest {
	String firststr;
	String secondstr;
	String operator;
	

}
