package com.springboot.project.digitalLibrary.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.digitalLibrary.entity.Book;
import com.springboot.project.digitalLibrary.entity.ResourceNotFoundException;
import com.springboot.project.digitalLibrary.entity.Student;
import com.springboot.project.digitalLibrary.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
public class StudentController {
	
	private StudentService service;
	
	@Autowired
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> findAll(){
		List<Student> studentList= service.findStudents();
		return ResponseEntity.status(HttpStatus.OK).body(studentList);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> findById(@PathVariable int studentId){
		Student student= service.findStudentById(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	@PostMapping("/student")
	public ResponseEntity<Student> create(@RequestBody Student student) {
		Student newStudent =service.createStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
	}
	@PutMapping("/student")
	public ResponseEntity<Student> update(@RequestBody Student student) {
		Student editedStudent =service.createStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(editedStudent);
	}
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<String> remove (@PathVariable int studentId) {
		Student student= service.findStudentById(studentId);
		if(student==null) {
			throw new ResourceNotFoundException("Studentid not found"+studentId);
		}
		service.removeStudent(studentId);
		String message= "deleted student with id: "+studentId;
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	
	
}
