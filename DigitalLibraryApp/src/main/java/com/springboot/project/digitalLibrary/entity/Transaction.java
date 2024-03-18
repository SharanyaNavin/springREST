package com.springboot.project.digitalLibrary.entity;

import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@CreationTimestamp
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
	
	@CreationTimestamp
	@Column(name="created_on")
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column(name="updated_on")
	private LocalDate updatedOn;
	
	@Column(name="card_id")
	private Integer cardId;
	
	@Column(name="book_id")
	private Integer bookId;
}
