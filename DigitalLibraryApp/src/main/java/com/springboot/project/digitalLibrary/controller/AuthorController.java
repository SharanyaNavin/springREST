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
import com.springboot.project.digitalLibrary.entity.Author;
import com.springboot.project.digitalLibrary.entity.ResourceNotFoundException;
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
	public ResponseEntity<List<Author>> findAll(){
		List<Author> authorList=service.findAuthors();
		return ResponseEntity.status(HttpStatus.OK).body(authorList);
	}
	
	@GetMapping("/author/{authorId}")
	public ResponseEntity<Author> findById(@PathVariable int authorId){
		Author author=service.findAuthorById(authorId);
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}
	@PostMapping("/author")
	public ResponseEntity<Author> create(@RequestBody Author author) {
		Author newAuthor= service.createAuthor(author);
		return ResponseEntity.status(HttpStatus.CREATED).body(newAuthor);
	}
	@PutMapping("/author")
	public ResponseEntity<Author> update(@RequestBody Author author) {
		Author editedAuthor= service.createAuthor(author);
		return ResponseEntity.status(HttpStatus.OK).body(editedAuthor);
	}
	@DeleteMapping("/author/{authorId}")
	public ResponseEntity<String> remove (@PathVariable int authorId) {
		Author author= service.findAuthorById(authorId);
		if(author==null) {
			throw new ResourceNotFoundException("Author id not found: "+authorId);
		}
		service.removeAuthor(authorId);
		String message ="deleted Author with id: "+authorId;
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	
}
