package com.springboot.project.digitalLibrary.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.project.digitalLibrary.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query(value="SELECT COUNT(s.id) FROM student s WHERE s.created_on=:date",
			nativeQuery = true)
	long findAllByDate(LocalDate date);
	
	@Query(value="SELECT s.id,s.name FROM student s JOIN card c ON s.card_id=c.id"
			+ " WHERE c.status='active'",nativeQuery = true)
	List<Object[]> findActiveStudents();

	@Query(value="SELECT s.id,s.name FROM student s JOIN card c ON s.card_id=c.id"
			+ " WHERE c.status='inactive'",nativeQuery = true)
	List<Object[]> findInActiveStudents();
}
