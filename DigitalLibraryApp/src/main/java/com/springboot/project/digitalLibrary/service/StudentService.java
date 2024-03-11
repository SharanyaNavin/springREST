package com.springboot.project.digitalLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.digitalLibrary.entity.ResourceNotFoundException;
import com.springboot.project.digitalLibrary.entity.Student;
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
	
	public List<Student> findStudents(){
		return studentRepository.findAll();		
	}
	
	public Student findStudentById(int id) {
		
		Optional<Student> result= studentRepository.findById(id);
		
		Student student =null;
		
		if(result.isPresent())
			student= result.get();
		else
			throw new ResourceNotFoundException("student not found id:"+id);
		
		return student;
	}	
	
	@Transactional
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Transactional
	public void removeStudent(int id) {
		 studentRepository.deleteById(id);
	}

}
