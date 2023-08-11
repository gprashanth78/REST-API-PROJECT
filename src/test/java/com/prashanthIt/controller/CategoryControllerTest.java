package com.prashanthIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.prashanthIt.service.CategoryService;

@WebMvcTest(value = CategoryController.class)
public class CategoryControllerTest {

	@MockBean
	private CategoryService service;

	@Autowired
	private MockMvc mockMvc;

	/*
	 * @Test public void testSaveCategoryDetails() throws Exception {
	 * when(service.addBookCategory(ArgumentMatchers.any())).thenReturn(true);
	 * 
	 * CategoryDetails category= new CategoryDetails(1, "Computer science");
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); String categoryJson =
	 * mapper.writeValueAsString(category);
	 * 
	 * MockHttpServletRequestBuilder reqBuilder =
	 * MockMvcRequestBuilders.post("/category/saveDetails")
	 * .contentType(MediaType.APPLICATION_JSON) .content(categoryJson);
	 * ResultActions perform = mockMvc.perform(reqBuilder); MvcResult result =
	 * perform.andReturn(); MockHttpServletResponse response = result.getResponse();
	 * int statusCode = response.getStatus(); assertEquals(201, statusCode); }
	 * 
	 * @Test public void testSaveCategoryDetails1() throws Exception {
	 * when(service.addBookCategory(ArgumentMatchers.any())).thenReturn(false);
	 * 
	 * CategoryDetails category= new CategoryDetails(1, "Computer science");
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); String categoryJson =
	 * mapper.writeValueAsString(category);
	 * 
	 * MockHttpServletRequestBuilder reqBuilder =
	 * MockMvcRequestBuilders.post("/category/saveDetails")
	 * .contentType(MediaType.APPLICATION_JSON) .content(categoryJson);
	 * ResultActions perform = mockMvc.perform(reqBuilder); MvcResult result =
	 * perform.andReturn(); MockHttpServletResponse response = result.getResponse();
	 * int statusCode = response.getStatus(); assertEquals(400, statusCode); }
	 * 
	 * @Test public void testGetAllCategories() throws Exception {
	 * List<CategoryDetails> categoryList = new ArrayList<>(); categoryList.add(new
	 * CategoryDetails(1, "computerScience")); categoryList.add(new
	 * CategoryDetails(2, "Mechanical"));
	 * when(service.getAllBooksCategory()).thenReturn(categoryList);
	 * 
	 * MockHttpServletRequestBuilder reqBuilder =
	 * MockMvcRequestBuilders.get("/category/getAllCategories"); ResultActions
	 * perform = mockMvc.perform(reqBuilder); MvcResult andReturn =
	 * perform.andReturn(); MockHttpServletResponse response =
	 * andReturn.getResponse(); int status = response.getStatus(); assertEquals(200,
	 * status); }
	 * 
	 * @Test public void testGetCategoryById() throws Exception { CategoryDetails
	 * category = new CategoryDetails(); category.setCategoryId(1);
	 * category.setCategoryName("Computer science");
	 * when(service.getBookCatgoryById(category.getCategoryId())).thenReturn(
	 * category);
	 * 
	 * MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
	 * MockMvcRequestBuilders.get("/category/getCategory/1"); ResultActions perform
	 * = mockMvc.perform(mockHttpServletRequestBuilder); MvcResult result =
	 * perform.andReturn(); MockHttpServletResponse response = result.getResponse();
	 * int status = response.getStatus(); assertEquals(200, status); }
	 * 
	 * @Test public void testEditCategoryById() throws Exception { CategoryDetails
	 * existingcategory = new CategoryDetails(); existingcategory.setCategoryId(1);
	 * existingcategory.setCategoryName("Computer science");
	 * 
	 * CategoryDetails category = new CategoryDetails(); category.setCategoryId(1);
	 * category.setCategoryName("Mechanical");
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); String categoryJson =
	 * mapper.writeValueAsString(category);
	 * 
	 * 
	 * when(service.getBookCatgoryById(category.getCategoryId())).thenReturn(
	 * existingcategory);
	 * when(service.addBookCategory(existingcategory)).thenReturn(true);
	 * 
	 * MockHttpServletRequestBuilder put =
	 * MockMvcRequestBuilders.put("/category/editCategory/1")
	 * .contentType(MediaType.APPLICATION_JSON) .content(categoryJson);
	 * ResultActions perform = mockMvc.perform(put);
	 * 
	 * MvcResult result = perform.andReturn(); MockHttpServletResponse response =
	 * result.getResponse(); int status = response.getStatus(); assertEquals(200,
	 * status); }
	 * 
	 * @Test public void testDeleteUserById() throws Exception { CategoryDetails
	 * category = new CategoryDetails(); category.setCategoryId(1);
	 * category.setCategoryName("Mechanical");
	 * 
	 * when(service.deleteBookCategoryById(category.getCategoryId())).thenReturn(
	 * true); MockHttpServletRequestBuilder reqBuilder =
	 * MockMvcRequestBuilders.get("/category/deleteCategory/1"); ResultActions
	 * perform = mockMvc.perform(reqBuilder); MvcResult andReturn =
	 * perform.andReturn(); MockHttpServletResponse response =
	 * andReturn.getResponse(); int status = response.getStatus(); assertEquals(200,
	 * status); }
	 * 
	 * @Test public void testDeleteUserById_1() throws Exception { CategoryDetails
	 * category = new CategoryDetails(); category.setCategoryId(1);
	 * category.setCategoryName("Mechanical");
	 * 
	 * when(service.deleteBookCategoryById(category.getCategoryId())).thenReturn(
	 * false); MockHttpServletRequestBuilder reqBuilder =
	 * MockMvcRequestBuilders.get("/category/deleteCategory/1"); ResultActions
	 * perform = mockMvc.perform(reqBuilder); MvcResult andReturn =
	 * perform.andReturn(); MockHttpServletResponse response =
	 * andReturn.getResponse(); int status = response.getStatus(); assertEquals(500,
	 * status); }
	 */
}
