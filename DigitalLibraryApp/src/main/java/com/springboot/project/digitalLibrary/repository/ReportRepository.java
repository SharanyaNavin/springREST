package com.springboot.project.digitalLibrary.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.project.digitalLibrary.entity.Transaction;

@Repository
public interface ReportRepository extends JpaRepository<Transaction, Integer>{
	@Query(value = "SELECT b.id,b.name FROM book b JOIN transaction t "
			      + "ON b.id=t.book_id "
			      + "WHERE t.is_issued=1 AND "
			      + "t.transaction_date BETWEEN :start AND :end",
		   nativeQuery = true)
	List<Object[]> findBooksIssuedByDateRange(LocalDate start, LocalDate end);
	
	@Query(value="SELECT SUM(t.fine_amount) FROM transaction t "
			    + "WHERE t.is_returned=1 AND "
			    + "t.transaction_date BETWEEN :start AND :end",
		   nativeQuery = true)
	int findFineCollectedByDateRange(LocalDate start, LocalDate end);
	
	@Query(value="SELECT COUNT(t.book_id) FROM transaction t "
			+ "WHERE t.updated_on BETWEEN :start AND :end",
			nativeQuery = true)
	long returnedBookCount(LocalDate start, LocalDate end);
	
	@Query(value="SELECT b.id,b.name FROM book b JOIN transaction t "
			+ "ON b.id=t.book_id "
			+ "WHERE t.book_due_date=:date",
			nativeQuery = true)
	List<Object[]> booksDueToday(LocalDate date);
	
	@Query(value="SELECT c.id,s.name FROM student s JOIN card c ON s.card_id=c.id "
			+ "JOIN transaction t ON c.id=t.card_id "
			+ "WHERE t.is_issued=1 "
			+ "GROUP BY t.card_id "
			+ "HAVING COUNT(t.card_id)=3",
			nativeQuery = true)
	List<Object[]> cardWithThreeBooks();
}
