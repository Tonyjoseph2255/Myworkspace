package com.example.amsarticleapi.entity;//java object

import javax.validation.constraints.Pattern;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;



import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
public class Category {
	@Id
    private String id;
	
	private Integer categoryId;
	@Size(max=5,message="categoryId is not lessthan 1")
	  @Range(min=1,max=1000,message="categoryId must be between 2 to 1000") 
	 
	  
	private String name;
	 @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  
	public Category(String id, Integer categoryId, String name) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
	}
	public Integer getCategoryid() {
		return categoryId;
	}
	public String getName() {
		return name;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryId = categoryid;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [categoryid=" + categoryId + ", name=" + name + "]";
	}
	

	
}