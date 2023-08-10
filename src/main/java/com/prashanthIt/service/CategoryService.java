package com.prashanthIt.service;

import java.util.List;

import com.prashanthIt.entity.CategoryDetails;

public interface CategoryService {

	public boolean addBookCategory(CategoryDetails category);

	public List<CategoryDetails> getAllBooksCategory();

	public CategoryDetails getBookCatgoryById(Integer categoryId);

	public boolean deleteBookCategoryById(Integer categoryId);
}
