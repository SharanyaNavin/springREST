package com.springboot.project.digitalLibrary.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="transaction_date")
	private LocalDate transactionDate;
	
	@Column(name="book_due_date")
	private LocalDate bookDueDate;
	
	@Column(name="is_issued")
	private boolean isIssued;
	
	@Column(name="is_returned")
	private boolean isReturned;
	
	@Column(name="fine_amount")
	private double fineAmount;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_on")
	private LocalDate createdOn;
	
	@Column(name="updated_on")
	private LocalDate updatedOn;
	
	@Column(name="card_id")
	private Integer cardId;
	
	@Column(name="book_id")
	private Integer bookId;
	

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(LocalDate transactionDate, LocalDate bookDueDate, boolean isIssued, boolean isReturned,
			double fineAmount, String status, LocalDate createdOn, LocalDate updatedOn) {
		super();
		this.transactionDate = transactionDate;
		this.bookDueDate = bookDueDate;
		this.isIssued = isIssued;
		this.isReturned = isReturned;
		this.fineAmount = fineAmount;
		this.status = status;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalDate getBookDueDate() {
		return bookDueDate;
	}

	public void setBookDueDate(LocalDate bookDueDate) {
		this.bookDueDate = bookDueDate;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", bookDueDate=" + bookDueDate
				+ ", isIssued=" + isIssued + ", isReturned=" + isReturned + ", fineAmount=" + fineAmount + ", status="
				+ status + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
}
