package com.springboot.project.digitalLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/transact")
public class TransactionController {
	private TransactionService service;
	
	@Autowired
	public TransactionController(TransactionService service) {
		super();
		this.service = service;
	}
	@GetMapping("/{transactionId}")
	public ResponseEntity<Transaction> findById(@PathVariable int transactionId){
		Transaction transaction= service.findTransactionById(transactionId);
		return ResponseEntity.status(HttpStatus.OK).body(transaction);
	}
	
	@GetMapping("/bookId/{bookId}")
	public ResponseEntity<List<Transaction>> findByBookId(@PathVariable int bookId){
		List<Transaction> transactionList= service.findTransactionByBookId(bookId);
		return ResponseEntity.status(HttpStatus.OK).body(transactionList);
	}

	@GetMapping("/cardId/{cardId}")
	public ResponseEntity<List<Transaction>> findByCardId(@PathVariable int cardId){
		List<Transaction> transactionList= service.findTransactionByCardId(cardId);
		return ResponseEntity.status(HttpStatus.OK).body(transactionList);
	}
	
	@GetMapping("/issueBook")
	public ResponseEntity<String> issueBook(@RequestParam(required = true)int bookId,
			@RequestParam(required = true)int cardId) {
		String message= service.issueBook(bookId, cardId);
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	}
	@GetMapping("/returnBook")
	public ResponseEntity<String> returnBook(@RequestParam(required = true) int bookId,
			@RequestParam(required = true) int cardId) {
		String message=service.returnBook(bookId, cardId);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

}
