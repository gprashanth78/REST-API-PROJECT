package com.prashanthIt.service;

import java.util.List;
import java.util.Map;

import com.prashanthIt.entity.BookDetails;

public interface BookDetailsService {
	
	public Map<Integer, String> getCategoryDetails();

	public boolean addBookDetails(BookDetails book);

	public List<BookDetails> getAllBookDetails();

	public BookDetails getBookDetailsById(Integer BookId);

	public boolean deleteBookDetailsById(Integer BookId);
}
