package com.springboot.project.digitalLibrary.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.digitalLibrary.repository.ReportRepository;
import com.springboot.project.digitalLibrary.repository.StudentRepository;
import com.springboot.project.digitalLibrary.repository.TransactionRepository;

@Service
public class ReportService {
	
	private ReportRepository reportRepository;
	
	private StudentRepository studentRepository;

	@Autowired
	public ReportService(ReportRepository reportRepository, StudentRepository studentRepository) {
		super();
		this.reportRepository = reportRepository;
		this.studentRepository = studentRepository;
	}
	// 1.All books issued in between a date range
	
	public List<Object[]> findBooksIssuedByDateRange(LocalDate startDate,LocalDate endDate){
		List<Object[]> books=reportRepository.findBooksIssuedByDateRange(startDate, endDate);
		return books;
	}
	
	//2. Total fine collected in between a date range
	
	public int findFineCollectedByDateRange(LocalDate start, LocalDate end) {
		int totalFineAmount=reportRepository.findFineCollectedByDateRange(start, end);
		return totalFineAmount;
	}
	
	//3. Total Students signed up on a date
	public long findStudentCountByDate(LocalDate date) {
		long totalStudents= studentRepository.findAllByDate(date);
		return totalStudents;
	}
	
	//4. Number of books returned in a date range
	public long findbookCountByDateRange(LocalDate start,LocalDate end) {
		long returnCount= reportRepository.returnedBookCount(start,end);
		return returnCount;
	}
	
	//5.List of all active students
	public List<Object[]> findActiveStudents(){
		List<Object[]> activeStudentsList=studentRepository.findActiveStudents();
		return activeStudentsList;
	}
	

	//6.List of all inactive students
	public List<Object[]> findInActiveStudents(){
		List<Object[]> activeStudentsList=studentRepository.findInActiveStudents();
		return activeStudentsList;
	}
	
	//7. List of Cards with student name who have 3 books issued
	public List<Object[]> cardWithThreeBooks(){
		List<Object[]> details=reportRepository.cardWithThreeBooks();
		return details;
	}
	//8. All books due to be returned today
	public List<Object[]> booksDueToday(){
		List<Object[]> books=reportRepository.booksDueToday(LocalDate.now());
		return books;
	}
	
}
