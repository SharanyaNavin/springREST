package com.springboot.project.digitalLibrary.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.project.digitalLibrary.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByCardIdAndStatus(int cardId, String status);

	Transaction findByBookIdAndCardId(int bookId, int cardId);

	List<Transaction> findByCardId(int cardId);

	List<Transaction> findByBookId(int bookId);

}
