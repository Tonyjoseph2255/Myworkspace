package com.example.StudentApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentApp.Entity.StudentEntity;
import com.example.StudentApp.Repository.StudentRepository;
import com.example.StudentApp.Request.StudentRequest;
import com.example.StudentApp.Response.StudentResponse;
import com.example.StudentApp.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping("/createstudent")
	public ResponseEntity<?>saveStudent(@RequestBody StudentRequest studentRequest){
		StudentResponse studentResponse=studentService.createStudDetail(studentRequest);
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
		
	}
	@GetMapping("/getStudentById/{student_id}")
	public ResponseEntity<?>getStudentById(@PathVariable (name="student_id")String student_id){
//		List<StudentEntity>studentEntities=studentService.getStudentById(student_id);
//		return new ResponseEntity<List<StudentEntity>>(studentEntities, HttpStatus.OK);
		//return new ResponseEntity<List<StudentEntity>>(studentEntities,HttpStatus.OK);
		StudentResponse response=studentService.getStudentById(student_id);
		return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
	}
	@PutMapping("/updateStud/{student_id}")
	public ResponseEntity<?>updateStud(@PathVariable (name="student_id")String student_id,@RequestBody StudentRequest studentRequest){
		StudentResponse updateResponse=studentService.updateStud(student_id,studentRequest);
		return new ResponseEntity<StudentResponse>(updateResponse, HttpStatus.OK);
	}
	

}
