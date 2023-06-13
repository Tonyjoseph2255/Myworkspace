package com.example.StudentApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document("student")
@Getter
@Setter
@ToString
public class StudentEntity {
	@Id

	private String student_id;
	private String student_name;
	private String address;
	private Integer mark;

}
