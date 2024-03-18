package com.springboot.project.digitalLibrary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.project.digitalLibrary.entity.Student;
import com.springboot.project.digitalLibrary.exception.ResourceNotFoundException;
import com.springboot.project.digitalLibrary.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	//Student CRUD operations
	
	public List<Student> findStudents(){
		return studentRepository.findAll();		
	}
	
	public Student findStudentById(int id) {

		Student student = studentRepository.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("Student not found id:" + id));
		
		return student;
	}	
	
	@Transactional
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Transactional
	public void removeStudent(int id) {

		Student student = studentRepository.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("Student not found id:" + id));
		
		 studentRepository.deleteById(id);
	}

}
