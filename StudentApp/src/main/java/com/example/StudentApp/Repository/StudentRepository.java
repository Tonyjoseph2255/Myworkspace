package com.example.StudentApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.StudentApp.Entity.StudentEntity;
import com.example.StudentApp.Response.StudentResponse;


public interface StudentRepository extends MongoRepository<StudentEntity, String> {

	
//	List<StudentEntity> findByStudentId(String studentId);
//	@Query("{categoryId:?0}")
//	StudentEntity findByStudentId(String student_id);
}
