package com.prashanthIt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanthIt.entity.CategoryDetails;
import com.prashanthIt.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public boolean addBookCategory(CategoryDetails category) {
		CategoryDetails save = categoryRepo.save(category);
		return save.getCategoryId() != null;
	}

	@Override
	public List<CategoryDetails> getAllBooksCategory() {

		return categoryRepo.findAll();
	}

	@Override
	public CategoryDetails getBookCatgoryById(Integer categoryId) {
		Optional<CategoryDetails> findById = categoryRepo.findById(categoryId);
		if (findById.isPresent()) {
			CategoryDetails category = findById.get();
			return category;
		}
		return null;
	}

	@Override
	public boolean deleteBookCategoryById(Integer categoryId) {
		categoryRepo.deleteById(categoryId);
		return true;
	}

}
