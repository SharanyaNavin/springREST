package com.springboot.project.digitalLibrary.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.project.digitalLibrary.entity.Book;
import com.springboot.project.digitalLibrary.service.BookAuthorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

	private BookAuthorService service;
	
	@Autowired
	public BookController(BookAuthorService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		
		List<Book> bookList=service.findBooks();
		
		return ResponseEntity.ok(bookList);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> findById(@PathVariable int bookId){
		
		Book book= service.findBookById(bookId);
		
		return ResponseEntity.ok(book);
	}
	
	@PostMapping
	public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
		
		Book newBook= service.createBook(book);
		
		return new ResponseEntity<>(newBook, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Book> update(@Valid @RequestBody Book book) {
		
		Book editedBook= service.createBook(book);
		
		return ResponseEntity.ok(editedBook);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> remove(@PathVariable int bookId) {
		
		service.removeBook(bookId);
		
		String message= "deleted Book with id: "+bookId;
		return ResponseEntity.ok(message);
	}
	
}
