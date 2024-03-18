package com.springboot.project.digitalLibrary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.project.digitalLibrary.entity.Author;
import com.springboot.project.digitalLibrary.entity.Book;
import com.springboot.project.digitalLibrary.exception.ResourceNotFoundException;
import com.springboot.project.digitalLibrary.repository.AuthorRepository;
import com.springboot.project.digitalLibrary.repository.BookRepository;
import jakarta.transaction.Transactional;

@Service
public class BookAuthorService {
	
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public BookAuthorService(BookRepository bookRepository,
			                 AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}
	//Book CRUD operations
	
	public List<Book> findBooks() {
		return bookRepository.findAll();
	}

	public Book findBookById(int id) {
		
		Book book = bookRepository.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("Book not found id:" + id));
		
		return book;
	}

	@Transactional
	public Book createBook(Book book) {
		
		return bookRepository.save(book);
	}

	@Transactional
	public void removeBook(int id) {
		
		Book book =bookRepository.findById(id).
		orElseThrow(()->new ResourceNotFoundException("Book not found id:" + id));
		bookRepository.deleteById(id);
	}
	
	//Author  CRUD operations
	
	public List<Author> findAuthors() {
		return authorRepository.findAll();
	}

	public Author findAuthorById(int id) {
		
		Author author = authorRepository.findById(id).
		orElseThrow(()->new ResourceNotFoundException("Author not found id:" + id));

		return author;
	}

	@Transactional
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Transactional
	public void removeAuthor(int id) {
		Author author = authorRepository.findById(id).
		orElseThrow(()->new ResourceNotFoundException("Author not found id:" + id));
		
		authorRepository.deleteById(id);
	}

	

}
