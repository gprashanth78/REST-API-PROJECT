package com.prashanthIt.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prashanthIt.entity.CategoryDetails;
import com.prashanthIt.service.CategoryService;

@WebMvcTest(value = CategoryController.class)
public class CategoryControllerTest {

	@MockBean
	private CategoryService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveCategoryDetails() throws Exception {
		when(service.addBookCategory(ArgumentMatchers.any())).thenReturn(true);
		
		CategoryDetails category= new CategoryDetails(1, "Computer science");
		
		ObjectMapper mapper = new ObjectMapper();
		String categoryJson = mapper.writeValueAsString(category);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/category/saveDetails")
																	  .contentType(MediaType.APPLICATION_JSON)
																	  .content(categoryJson);
		ResultActions perform = mockMvc.perform(reqBuilder);
		MvcResult result = perform.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int statusCode = response.getStatus();
		assertEquals(201, statusCode);
	}
	
	@Test
	public void testSaveCategoryDetails1() throws Exception {
		when(service.addBookCategory(ArgumentMatchers.any())).thenReturn(false);
		
		CategoryDetails category= new CategoryDetails(1, "Computer science");
		
		ObjectMapper mapper = new ObjectMapper();
		String categoryJson = mapper.writeValueAsString(category);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/category/saveDetails")
																	  .contentType(MediaType.APPLICATION_JSON)
																	  .content(categoryJson);
		ResultActions perform = mockMvc.perform(reqBuilder);
		MvcResult result = perform.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int statusCode = response.getStatus();
		assertEquals(400, statusCode);
	}
	
	@Test
	public void testGetAllCategories() throws Exception {
		List<CategoryDetails> categoryList= new ArrayList<>();
		categoryList.add(new CategoryDetails(1, "computerScience"));
		categoryList.add(new CategoryDetails(2, "Mechanical"));
		when(service.getAllBooksCategory()).thenReturn(categoryList);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/category/getAllCategories");
		ResultActions perform = mockMvc.perform(reqBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
}
