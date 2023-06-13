package com.example.amsarticleapi.service;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amsarticleapi.entity.Category;
import com.example.amsarticleapi.exception.CategoryException;
import com.example.amsarticleapi.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository catrepo;

	private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);

	public List<Category> getCategory() {
		// return Arrays.asList(new Category(1,"sports"),
		// new Category(2,"Technology"));
		return catrepo.findAll();
	}

	public Category getCategoryById(Integer id) throws CategoryException {
		// Validation
		// Validation-failed-throw-error
		// Validation-success-call-mongoservice
		// if(id>99) {
		// throw new CategoryException("Invalid Category");
		// }
		Category a = catrepo.findCategoryByCategoryid(id);

		if (a == null) {
			throw new CategoryException("Id: " + id + " is not present");
		} else

		{
			LOGGER.info("Resource found" + a);
			return a;
		}

	}

}