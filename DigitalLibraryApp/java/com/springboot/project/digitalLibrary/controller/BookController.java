package com.springboot.project.digitalLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.project.digitalLibrary.entity.Book;
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
	public List<Book> findAll(){
		return service.findBooks();
	}
	@GetMapping("/book/{bookId}")
	public Book findById(@PathVariable int bookId){
		return service.findBookById(bookId);
	}
	@PostMapping("/book")
	public Book create(@RequestBody Book book) {
		return service.createBook(book);
	}
	@PutMapping("/book")
	public Book update(@RequestBody Book book) {
		return service.createBook(book);
	}
	@DeleteMapping("/book/{bookId}")
	public String remove (@PathVariable int bookId) {
		service.removeBook(bookId);
		return "deleted Book with id: "+bookId;
	}
	
}
