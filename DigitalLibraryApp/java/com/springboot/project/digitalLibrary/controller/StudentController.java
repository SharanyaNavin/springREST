package com.springboot.project.digitalLibrary.controller;

import org.springframework.web.bind.annotation.RestController;
import com.springboot.project.digitalLibrary.entity.Student;
import com.springboot.project.digitalLibrary.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Student> findAll(){
		return service.findStudents();
	}
	
	@GetMapping("/student/{studentId}")
	public Student findById(@PathVariable int studentId){
		return service.findStudentById(studentId);
	}
	@PostMapping("/student")
	public Student create(@RequestBody Student student) {
		return service.createStudent(student);
	}
	@PutMapping("/student")
	public Student update(@RequestBody Student student) {
		return service.createStudent(student);
	}
	@DeleteMapping("/student/{studentId}")
	public String remove (@PathVariable int studentId) {
		service.removeStudent(studentId);
		return "deleted student with id: "+studentId;
	}
	
	
	
}
