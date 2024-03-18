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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="isbn_number")
	private String isbnNumber;
	
	@Column(name="published_date")
	private LocalDate publishedDate;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="book_id")
	List<Transaction> transactions;
}
