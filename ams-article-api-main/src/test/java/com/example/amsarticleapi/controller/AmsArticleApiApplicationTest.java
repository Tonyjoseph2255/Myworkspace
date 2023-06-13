package com.example.amsarticleapi.controller;

import org.junit.runner.RunWith;

import java.util.UUID;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.amsarticleapi.entity.Category;
import com.example.amsarticleapi.repository.CategoryRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AmsArticleApiApplicationTest {
	public AmsArticleApiApplicationTest() {
	}

	MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@Autowired
	CategoryRepository catrepo;

@Before
	public void setUp() {
		Category cat1 = new Category(UUID.randomUUID().toString(), 3, "Startups");
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		catrepo.insert(cat1);
	}

	@Test
	public void APIArticleTest() throws Exception {
		String uri = "http://localhost:8080/getcategory/3";

		String inputJson = "{\"categoryId\":\"101\"}";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		System.out.println(mvcResult.getResponse().toString());
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		JSONObject responseObj = new JSONObject(content);
		System.out.println();
		Assert.assertEquals("Startups", responseObj.getString("name"));
	}

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
}
