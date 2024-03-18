package com.springboot.project.digitalLibrary.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.project.digitalLibrary.entity.Book;
import com.springboot.project.digitalLibrary.entity.Card;
import com.springboot.project.digitalLibrary.entity.Transaction;
import com.springboot.project.digitalLibrary.exception.ResourceNotFoundException;
import com.springboot.project.digitalLibrary.repository.BookRepository;
import com.springboot.project.digitalLibrary.repository.CardRepository;
import com.springboot.project.digitalLibrary.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {

	private TransactionRepository transactionRepository;
	private BookRepository bookRepository;
	private CardRepository cardRepository;

	@Autowired
	public TransactionService(TransactionRepository transactionRepository, 
			BookRepository bookRepository,
			CardRepository cardRepository) {
		super();
		this.transactionRepository = transactionRepository;
		this.bookRepository = bookRepository;
		this.cardRepository = cardRepository;
	}

	public Book findBookById(int bookId) {

		Book book = bookRepository.findById(bookId)
		.orElseThrow(()->new ResourceNotFoundException("Book not found id:" + bookId));
		
		return book;
	}

	public Card findCardById(int cardId) {

		Card card = cardRepository.findById(cardId)
		.orElseThrow(()->new ResourceNotFoundException("Card not found id:" + cardId));

		return card;
	}
	
	//issue book 
	@Transactional
	public String issueBook(int bookId, int cardId) {

		Card cardDetails = findCardById(cardId);
		Book bookDetails = findBookById(bookId);

		String status = "success";
		List<Transaction> activeTransactions = transactionRepository.
				                               findByCardIdAndStatus(cardId, status);

		if (cardDetails.getStatus().equals("active") &&
				bookDetails.isAvailable() && 
				activeTransactions.size() < 3) {

			// 1. create a new transaction
			Transaction issueBookTransaction = Transaction.builder().
					                        bookDueDate(LocalDate.now().plusMonths(3)).
					                        isIssued(true).
					                        status("success").
					                        bookId(bookId).
					                        cardId(cardId).
					                        build();

			transactionRepository.save(issueBookTransaction);

			// 2.mark book as unavailable
			bookDetails.setAvailable(false);

			return "Book Issued";

		} else {

			Transaction failedTransaction = Transaction.builder().
					                        status("failure").
					                        cardId(cardId).
					                        bookId(bookId).
					                        build();

			transactionRepository.save(failedTransaction);

			return "Book not issued";
		}
	}

	//return book 
	public String returnBook(int bookId, int cardId) {

		double fineAmount = 0;
		Card cardDetails = findCardById(cardId);
		Book bookDetails = findBookById(bookId);
		
		String status = "success";
		Transaction returnBookTransaction = transactionRepository.
				                findByBookIdCardIdAndStatus(bookId, cardId,status);

		if (cardDetails.getStatus().equals("active") && 
				returnBookTransaction != null) {
		
		// 1.mark book as available
			bookDetails.setAvailable(true);

		// 2.calculate fine
			LocalDate bookDueDate = returnBookTransaction.getBookDueDate();
			LocalDate todayDate = LocalDate.now();

			if (todayDate.isAfter(bookDueDate)) {
				
				long daysBetween = ChronoUnit.DAYS.between(bookDueDate, todayDate);
				fineAmount = daysBetween * 5;
				returnBookTransaction.setFineAmount(fineAmount);
			}
			
		// 3.set cardId to null
			returnBookTransaction.setCardId(null);
			returnBookTransaction.setReturned(true);

			transactionRepository.save(returnBookTransaction);
		}

		return "Book Returned and your fine amount is: $" + fineAmount;

	}

	//find transaction by id
	public Transaction findTransactionById(int id) {

		Transaction transaction = transactionRepository.findById(id).
	   orElseThrow(()->new ResourceNotFoundException("transaction not found id:" +id));
				
		return transaction;
	}

	//find transaction by bookId
	public List<Transaction> findTransactionByBookId(int bookId) {
		List<Transaction> bookTransactions = transactionRepository.
				                             findByBookId(bookId);

		return bookTransactions;
	}

	//find transaction by cardId
	public List<Transaction> findTransactionByCardId(int cardId) {
		List<Transaction> cardTransactions = transactionRepository.
				                              findByCardId(cardId);

		return cardTransactions;
	}

}
