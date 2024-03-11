package com.springboot.project.digitalLibrary.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Object[]>> booksIssuedBetween(@RequestParam (required = true)LocalDate start,
			                                @RequestParam(required = true)LocalDate end){
		List<Object[]> booksIssued= service.findBooksIssuedByDateRange(start, end);
		return ResponseEntity.status(HttpStatus.OK).body(booksIssued);
	}
	
	@GetMapping("/fineCollected")
	public ResponseEntity<String> fineCollectedBetween(@RequestParam (required = true)LocalDate start,
			                                @RequestParam(required = true)LocalDate end){
		int totalFineAmount= service.findFineCollectedByDateRange(start, end);
		String message= "Total fine amount: $"+totalFineAmount;
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@GetMapping("/studentCount")
	public ResponseEntity<Long> studentCount(@RequestParam (required = true)LocalDate date) {
		long count= service.findStudentCountByDate(date);
		return ResponseEntity.status(HttpStatus.OK).body(count);
	}

	@GetMapping("/returnBookCount")
	public ResponseEntity<Long> returnBookCount(@RequestParam(required = true)LocalDate start,
			  @RequestParam(required = true)LocalDate end){
		long count= service.findbookCountByDateRange(start,end);
		return ResponseEntity.status(HttpStatus.OK).body(count);
	}
	
	@GetMapping("/activeStudents")
	public ResponseEntity<List<Object[]>> activeStudents(){
		List<Object[]> activeStudents=service.findActiveStudents();
		return ResponseEntity.status(HttpStatus.OK).body(activeStudents);
	}

	@GetMapping("/inactiveStudents")
	public ResponseEntity<List<Object[]>> inActiveStudents(){
		List<Object[]> inActiveStudents=service.findInActiveStudents();
		return ResponseEntity.status(HttpStatus.OK).body(inActiveStudents);
	}
	@GetMapping("/booksDueToday")
	public ResponseEntity<List<Object[]>> booksDueToday(){
		List<Object[]> books= service.booksDueToday();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	@GetMapping("/cardDetails")
	public ResponseEntity<List<Object[]>> cardWithThreeBooks(){
		List<Object[]> details=service.cardWithThreeBooks();
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}
}
