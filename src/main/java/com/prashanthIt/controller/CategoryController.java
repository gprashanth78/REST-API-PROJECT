package com.prashanthIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prashanthIt.entity.CategoryDetails;
import com.prashanthIt.service.CategoryService;

/**
 * @author Prashanth G
 * @version 1.0
 * @CreatedDate Aug 08, 2023 This class is used to work with CRUD operation of Category Details
 */
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping(value = "/category/saveDetails", consumes = "application/json")
	public ResponseEntity<String> saveCategoryDetails(@RequestBody CategoryDetails category) {
		boolean addBookCategory = categoryService.addBookCategory(category);
		if (addBookCategory) {
			return new ResponseEntity<String>("Details saved", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Unable to save Details", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/category/getAllCategories", produces = "application/json")
	public ResponseEntity<List<CategoryDetails>> getAllCategories() {
		List<CategoryDetails> listCategories = categoryService.getAllBooksCategory();
		return new ResponseEntity<List<CategoryDetails>>(listCategories, HttpStatus.OK);
	}

	@GetMapping(value = "/category/getCategory/{categoryId}", produces = "application/json")
	public ResponseEntity<CategoryDetails> getCategoryById(@PathVariable("categoryId") Integer categoryId) {
		CategoryDetails category = categoryService.getBookCatgoryById(categoryId);
		return new ResponseEntity<CategoryDetails>(category, HttpStatus.OK);
	}

	@PutMapping(value = "/category/editCategory/{categoryId}", consumes = "application/json")
	public ResponseEntity<CategoryDetails> editUserById(@RequestBody CategoryDetails categoryDetails,
			@PathVariable("categoryId") Integer categoryId) {
		CategoryDetails category = categoryService.getBookCatgoryById(categoryId);
		category.setCategoryName(categoryDetails.getCategoryName());
		@SuppressWarnings("unused")
		boolean updateCategory = categoryService.addBookCategory(category);
		return new ResponseEntity<CategoryDetails>(HttpStatus.OK);
	}

	@GetMapping(value = "/category/deleteCategory/{categoryId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("categoryId") Integer categoryId) {
		boolean deleteCategory = categoryService.deleteBookCategoryById(categoryId);
		if (deleteCategory) {
			return new ResponseEntity<String>("Category Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed to Delete", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
