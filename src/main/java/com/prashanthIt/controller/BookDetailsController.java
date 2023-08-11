package com.prashanthIt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prashanthIt.entity.BookDetails;
import com.prashanthIt.service.BookDetailsService;

@RestController
public class BookDetailsController {

	@Autowired
	private BookDetailsService bookService;

	@GetMapping(value = "/book/categoryDetails", produces = "application/json")
	public Map<Integer, String> getCategoryDetails() {
		Map<Integer, String> categoryDetails = bookService.getCategoryDetails();
		return categoryDetails;
	}

	@PostMapping(value = "/book/saveBookDetails", consumes = "application/json")
	public ResponseEntity<String> addBookDetails(@RequestBody BookDetails book) {
		boolean addBook = bookService.addBookDetails(book);
		if (addBook) {
			return new ResponseEntity<String>("Book Details saved", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Book Details Not saved", HttpStatus.BAD_REQUEST);
		}
	}
}
