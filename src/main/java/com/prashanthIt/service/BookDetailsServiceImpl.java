package com.prashanthIt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanthIt.entity.BookDetails;
import com.prashanthIt.entity.CategoryDetails;
import com.prashanthIt.repository.BookDetailsRepository;
import com.prashanthIt.repository.CategoryRepository;

@Service
public class BookDetailsServiceImpl implements BookDetailsService {

	@Autowired
	private BookDetailsRepository bookRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Map<Integer, String> getCategoryDetails() {
		List<CategoryDetails> categoryList = categoryRepo.getAllCategoryDetails();
		Map<Integer, String> categoryMap = new HashMap<>();
		for (CategoryDetails category : categoryList) {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		}
		return categoryMap;
	}

	@Override
	public boolean addBookDetails(BookDetails book) {
		BookDetails save = bookRepo.save(book);
		return save.getBookId() != null;
	}

	@Override
	public List<BookDetails> getAllBookDetails() {
		return bookRepo.findAll();
	}

	@Override
	public BookDetails getBookDetailsById(Integer BookId) {
		Optional<BookDetails> findById = bookRepo.findById(BookId);
		if (findById.isPresent()) {
			BookDetails bookDetails = findById.get();
			return bookDetails;
		}
		return null;
	}

	@Override
	public boolean deleteBookDetailsById(Integer BookId) {
		bookRepo.deleteById(BookId);
		return true;
	}

}
