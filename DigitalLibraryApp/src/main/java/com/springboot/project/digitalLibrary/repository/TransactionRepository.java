package com.springboot.project.digitalLibrary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.project.digitalLibrary.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByCardIdAndStatus(int cardId, String status);

	@Query(value = "SELECT * FROM transaction t WHERE "
			      + "t.book_id=:bookId AND "
			      + "t.card_id=:cardId AND "
			      + "t.status=:status",
		          nativeQuery = true)
	Transaction findByBookIdCardIdAndStatus(int bookId, int cardId,String status);

	List<Transaction> findByCardId(int cardId);

	List<Transaction> findByBookId(int bookId);

}
