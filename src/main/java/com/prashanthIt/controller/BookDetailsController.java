package com.prashanthIt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping(value = "/book/saveBookDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBookDetails(@RequestBody BookDetails book) {
		boolean addBook = bookService.addBookDetails(book);
		if (addBook) {
			return new ResponseEntity<String>("Book Details saved", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Book Details Not saved", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/book/getAllBooks", produces = "application/json")
	public ResponseEntity<List<BookDetails>> retrieveAllBookDetails() {
		List<BookDetails> listOfBooks = bookService.getAllBookDetails();
		return new ResponseEntity<List<BookDetails>>(listOfBooks, HttpStatus.OK);
	}

	@GetMapping(value = "/book/getBookDetails/{bookId}", produces = "application/json")
	public ResponseEntity<BookDetails> getBookDetailsById(@PathVariable("bookId") Integer bookId) {
		BookDetails bookDetails = bookService.getBookDetailsById(bookId);
		if (bookDetails != null) {
			return new ResponseEntity<BookDetails>(bookDetails, HttpStatus.OK);
		}
		return new ResponseEntity<BookDetails>(bookDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping(value = "/book/editBookDetails/{bookId}", consumes = "application/json")
	public ResponseEntity<BookDetails> updateBookDetailsById(@RequestBody BookDetails book,
			@PathVariable("bookId") Integer bookId) {
		BookDetails bookDetails = bookService.getBookDetailsById(bookId);
		bookDetails.setBookDescription(book.getBookDescription());
		bookDetails.setBookPrice(book.getBookPrice());
		bookDetails.setPublishedDate(book.getPublishedDate());
		bookDetails.setAuthor(book.getAuthor());
		bookDetails.setBookImage(book.getBookImage());
		boolean addBookDetails = bookService.addBookDetails(bookDetails);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/book/deleteBook/{bookId}")
	public ResponseEntity<String> deleteBookDetailsById(@PathVariable("bookId") Integer bookId) {
		boolean deleteBook = bookService.deleteBookDetailsById(bookId);
		if (deleteBook) {
			return new ResponseEntity<String>("Book Details Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Unable to Deleted", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
