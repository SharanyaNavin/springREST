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
import com.springboot.project.digitalLibrary.entity.Author;
import com.springboot.project.digitalLibrary.service.BookAuthorService;

@RestController
public class AuthorController {

	private BookAuthorService service;
	
	@Autowired
	public AuthorController(BookAuthorService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/author")
	public List<Author> findAll(){
		return service.findAuthors();
	}
	
	@GetMapping("/author/{authorId}")
	public Author findById(@PathVariable int authorId){
		return service.findAuthorById(authorId);
	}
	@PostMapping("/author")
	public Author create(@RequestBody Author author) {
		return service.createAuthor(author);
	}
	@PutMapping("/author")
	public Author update(@RequestBody Author author) {
		return service.createAuthor(author);
	}
	@DeleteMapping("/author/{authorId}")
	public String remove (@PathVariable int authorId) {
		service.removeAuthor(authorId);
		return "deleted Author with id: "+authorId;
	}
	
	
}
