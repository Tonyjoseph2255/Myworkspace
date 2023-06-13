package com.example.StudentApp.Service;

import java.util.Optional;

import javax.management.remote.SubjectDelegationPermission;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentApp.Entity.StudentEntity;
import com.example.StudentApp.Repository.StudentRepository;
import com.example.StudentApp.Request.StudentRequest;
import com.example.StudentApp.Response.StudentResponse;
import com.example.StudentApp.Exeption.StudentNotFoundException;
@Service
public class StudentService {
	@Autowired 
	 private StudentRepository studentRepository;
	@Autowired
	private ModelMapper mapper;

	public StudentResponse createStudDetail(StudentRequest studentRequest) {
	StudentEntity studentEntity=new StudentEntity();
	mapper.map(studentRequest, studentEntity);
	studentEntity=studentRepository.save(studentEntity);
	StudentResponse studentResponse=new StudentResponse();
	mapper.map(studentEntity, studentResponse);
		return studentResponse;
	}

	public StudentResponse getStudentById(String student_id) {
		System.out.println(student_id);
		
		 StudentEntity studentData = studentRepository.findById(student_id).orElse(new StudentEntity());
      
		 
		StudentResponse studentResponse= new StudentResponse();
		mapper.map(studentData, studentResponse);
		return studentResponse;
	}

	public StudentResponse updateStud(String student_id, StudentRequest studentRequest) {
		Optional<StudentEntity> studentEntity=studentRepository.findById(student_id);
		if (!studentEntity.isPresent()) {
	       System.out.println("student with id is not present");
	    }
		StudentEntity optionalStudentEntity=studentEntity.get();
		mapper.map(studentRequest, optionalStudentEntity);
		optionalStudentEntity=studentRepository.save(optionalStudentEntity);
		
		StudentResponse studentResponse= new StudentResponse();
		mapper.map(optionalStudentEntity,studentResponse);
		
		return studentResponse;
	}

//	public StudentResponse updateStud(String student_id, StudentRequest studentRequest) {
//		// TODO Auto-generated method stub
//		System.out.println(studentRequest);
//		
//		 StudentEntity studentData = studentRepository.findById(student_id).orElse(new StudentEntity());
//		 StudentResponse updateResponse=new StudentResponse();
//			
//		updateResponse.setStudent_name(studentRequest.getStudent_name());
//		updateResponse.setAddress(studentRequest.getAddress());
//		updateResponse.setMark(studentRequest.getMark());
//		mapper.map(updateResponse, studentData);
//		studentRepository.save(studentData);
//		return updateResponse;
//	}

	
//	public List<StudentEntity> getStudentById(String student_id) {
//		// TODO Auto-generated method stub
//	 List<StudentEntity>response=studentRepository.findByStudentId(student_id);
//	 response=response.stream().map(x->{x.setStudent_name(null);return x;}).collect(Collectors.toList());
//		
//	
//		return response;
//	}

}
