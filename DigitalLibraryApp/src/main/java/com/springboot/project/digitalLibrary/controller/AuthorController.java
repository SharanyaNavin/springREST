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
import com.springboot.project.digitalLibrary.entity.Author;
import com.springboot.project.digitalLibrary.service.BookAuthorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

	private BookAuthorService service;
	
	@Autowired
	public AuthorController(BookAuthorService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll(){
		
		List<Author> authorList=service.findAuthors();
		
		return ResponseEntity.ok(authorList);
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity<Author> findById(@PathVariable int authorId){
		
		Author author=service.findAuthorById(authorId);
		
		return ResponseEntity.ok(author);
	}
	
	@PostMapping
	public ResponseEntity<Author> create(@Valid @RequestBody Author author) {
		
		Author newAuthor= service.createAuthor(author);
		
		return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Author> update(@Valid @RequestBody Author author) {
		
		Author editedAuthor= service.createAuthor(author);
		
		return ResponseEntity.ok(editedAuthor);
	}
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity<String> remove (@PathVariable int authorId) {
		
		service.removeAuthor(authorId);
		
		String message ="deleted Author with id: "+authorId;
		return ResponseEntity.ok(message);
	}
	
	
}
