package com.springboot.project.digitalLibrary.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.digitalLibrary.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
	private ReportService service;

	public ReportController(ReportService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/booksIssued")
	public List<Object[]> booksIssuedBetween(@RequestParam (required = true)LocalDate start,
			                                @RequestParam(required = true)LocalDate end){
		List<Object[]> booksIssued= service.findBooksIssuedByDateRange(start, end);
		return booksIssued;
	}
	
	@GetMapping("/fineCollected")
	public String fineCollectedBetween(@RequestParam (required = true)LocalDate start,
			                                @RequestParam(required = true)LocalDate end){
		int totalFineAmount= service.findFineCollectedByDateRange(start, end);
		return "Total fine amount: $"+totalFineAmount;
	}
	
	@GetMapping("/studentCount")
	public long studentCount(@RequestParam (required = true)LocalDate date) {
		long count= service.findStudentCountByDate(date);
		return count;
	}

	@GetMapping("/returnBookCount")
	public long returnBookCount(@RequestParam(required = true)LocalDate start,
			  @RequestParam(required = true)LocalDate end){
		long count= service.findbookCountByDateRange(start,end);
		return count;
	}
	
	@GetMapping("/activeStudents")
	public List<Object[]> activeStudents(){
		List<Object[]> activeStudents=service.findActiveStudents();
		return activeStudents;
	}

	@GetMapping("/inactiveStudents")
	public List<Object[]> inActiveStudents(){
		List<Object[]> activeStudents=service.findInActiveStudents();
		return activeStudents;
	}
	@GetMapping("/booksDueToday")
	public List<Object[]> booksDueToday(){
		List<Object[]> books= service.booksDueToday();
		return books;
	}
	@GetMapping("/cardDetails")
	List<Object[]> cardWithThreeBooks(){
		List<Object[]> details=service.cardWithThreeBooks();
		return details;
	}
}
