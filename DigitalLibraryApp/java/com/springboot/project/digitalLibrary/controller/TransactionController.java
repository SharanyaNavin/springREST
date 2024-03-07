package com.springboot.project.digitalLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.digitalLibrary.entity.Student;
import com.springboot.project.digitalLibrary.entity.Transaction;
import com.springboot.project.digitalLibrary.service.TransactionService;

@RestController
public class TransactionController {
	private TransactionService service;
	
	@Autowired
	public TransactionController(TransactionService service) {
		super();
		this.service = service;
	}
	@GetMapping("/transact/{transactionId}")
	public Transaction findById(@PathVariable int transactionId){
		return service.findTransactionById(transactionId);
	}
	
	@GetMapping("/transact/bookId/{bookId}")
	public List<Transaction> findByBookId(@PathVariable int bookId){
		return service.findTransactionByBookId(bookId);
	}

	@GetMapping("/transact/cardId/{cardId}")
	public List<Transaction> findByCardId(@PathVariable int cardId){
		return service.findTransactionByCardId(cardId);
	}
	
	@GetMapping("/transact/issueBook")
	public String issueBook(@RequestParam(required = true)int bookId,@RequestParam(required = true)int cardId) {
		return service.issueBook(bookId, cardId);
		
	}
	@GetMapping("/transact/returnBook")
	public String returnBook(@RequestParam(required = true) int bookId,@RequestParam(required = true) int cardId) {
		return service.returnBook(bookId, cardId);
	}

}
