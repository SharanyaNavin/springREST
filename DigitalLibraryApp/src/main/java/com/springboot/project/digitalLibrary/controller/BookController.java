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
import org.springframework.web.bind.annotation.RestController;
import com.springboot.project.digitalLibrary.entity.Book;
import com.springboot.project.digitalLibrary.entity.ResourceNotFoundException;
import com.springboot.project.digitalLibrary.service.BookAuthorService;

@RestController
public class BookController {

	private BookAuthorService service;
	
	@Autowired
	public BookController(BookAuthorService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> findAll(){
		List<Book> bookList=service.findBooks();
		return ResponseEntity.status(HttpStatus.OK).body(bookList);
	}
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> findById(@PathVariable int bookId){
		Book book= service.findBookById(bookId);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	@PostMapping("/book")
	public ResponseEntity<Book> create(@RequestBody Book book) {
		Book newBook= service.createBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
	}
	@PutMapping("/book")
	public ResponseEntity<Book> update(@RequestBody Book book) {
		Book editedBook= service.createBook(book);
		return ResponseEntity.status(HttpStatus.OK).body(editedBook);
	}
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> remove (@PathVariable int bookId) {
		Book book= service.findBookById(bookId);
		if(book==null) {
			throw new ResourceNotFoundException("Bookid not found"+bookId);
		}
		service.removeBook(bookId);
		String message= "deleted Book with id: "+bookId;
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
}
