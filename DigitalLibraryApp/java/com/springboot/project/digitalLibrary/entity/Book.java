package com.springboot.project.digitalLibrary.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="author_id")
	private Author author;
	
	@Column(name="number_of_pages")
	private int numberOfPages;
	
	@Column(name="language")
	private String language;
	
	@Column(name="available")
	private boolean available;
	
	@Column(name="gener")
	private String gener;
	
	@Column(name="isbn_number")
	private String isbnNumber;
	
	@Column(name="published_date")
	private LocalDate publishedDate;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="book_id")
	List<Transaction> transactions;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Book(String name, Author author, int numberOfPages, String language, boolean available, String gener,
			String isbnNumber, LocalDate publishedDate) {
		super();
		this.name = name;
		this.author = author;
		this.numberOfPages = numberOfPages;
		this.language = language;
		this.available = available;
		this.gener = gener;
		this.isbnNumber = isbnNumber;
		this.publishedDate = publishedDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	
	public List<Transaction> getTransactions() {
		return transactions;
	}



	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", numberOfPages=" + numberOfPages
				+ ", language=" + language + ", available=" + available + ", gener=" + gener + ", isbnNumber="
				+ isbnNumber + ", publishedDate=" + publishedDate + ", transactions=" + transactions + "]";
	}


	
	
	
}
