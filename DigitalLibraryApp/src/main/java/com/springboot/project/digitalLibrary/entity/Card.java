package com.springboot.project.digitalLibrary.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="card")
public class Card {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="status")
	private String status;
	

	@Column(name="email")
	private String email;
	
	@Column(name="valid_upto")
	private LocalDate validUpto;
	
	@Column(name="created_on")
	private LocalDate createdOn;
	
	@Column(name="updated_on")
	private LocalDate updatedOn;
	
	@OneToMany
	@JoinColumn(name="card_id")
	private List<Transaction> transactions;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(String status, String email, LocalDate validUpto, LocalDate createdOn, LocalDate updatedOn) {
		super();
		this.status = status;
		this.email = email;
		this.validUpto = validUpto;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(LocalDate validUpto) {
		this.validUpto = validUpto;
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
	

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", status=" + status + ", email=" + email + ", validUpto=" + validUpto
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	
	
}
