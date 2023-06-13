package com.example.amsarticleapi.controller;

import java.util.List;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.amsarticleapi.entity.Category;
import com.example.amsarticleapi.exception.CategoryException;
import com.example.amsarticleapi.service.CategoryService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@Validated
public class CategoryController {
	private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getcategory")
	public List<Category> getAllCategory()

	{

		return categoryService.getCategory();
	}

	@GetMapping("/getcategory/{id}")

	public Category getCategoryById(@PathVariable("id") @Min(1) @Max(100) Integer id) throws CategoryException {

		return categoryService.getCategoryById(id);

		// }

	}
}
