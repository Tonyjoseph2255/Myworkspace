package com.example.StudentApp.Request;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Document
public class StudentRequest {
	private String student_id;
	private String student_name;
	private String address;
	private Integer mark;

}
