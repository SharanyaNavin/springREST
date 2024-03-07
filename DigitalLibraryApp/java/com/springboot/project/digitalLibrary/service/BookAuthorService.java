package com.springboot.project.digitalLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.digitalLibrary.entity.Author;
import com.springboot.project.digitalLibrary.entity.Book;
import com.springboot.project.digitalLibrary.entity.ResourceNotFoundException;
import com.springboot.project.digitalLibrary.repository.AuthorRepository;
import com.springboot.project.digitalLibrary.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookAuthorService {
	
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public BookAuthorService(BookRepository bookRepository, AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}
	
	public List<Book> findBooks() {
		return bookRepository.findAll();
	}

	public Book findBookById(int id) {
		Optional<Book> result = bookRepository.findById(id);

		Book book = null;

		if (result.isPresent())
			book = result.get();
		else 
			throw new ResourceNotFoundException("Book not found id:" + id);

		return book;
		
		
	}

	@Transactional
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Transactional
	public void removeBook(int id) {
		bookRepository.deleteById(id);
	}
	
	public List<Author> findAuthors() {
		return authorRepository.findAll();
	}

	public Author findAuthorById(int id) {
		Optional<Author> result = authorRepository.findById(id);

		Author author = null;

		if (result.isPresent())
			author = result.get();
		else
			throw new ResourceNotFoundException("Author not found id:" + id);

		return author;
	}

	@Transactional
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Transactional
	public void removeAuthor(int id) {
		authorRepository.deleteById(id);
	}

	

}
