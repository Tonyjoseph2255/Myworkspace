package com.example.amsarticleapi.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.amsarticleapi.repository.CategoryRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
MockMvc mvc;
@Autowired
WebApplicationContext webApplicationContext;
@Autowired
CategoryRepository catrepo;

public class GetcategoryTest {
	@Test
	public void GetCategoryTest() throws Exception {
		String uri = "http://localhost:8080/getcategory";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

		System.out.println(mvcResult.getResponse().toString());
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(content);
		int categoriesSize = root.size();
		Assert.assertEquals(2, categoriesSize);
}
