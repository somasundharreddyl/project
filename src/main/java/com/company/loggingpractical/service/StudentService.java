package com.company.loggingpractical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.loggingpractical.entity.Student;
import com.company.loggingpractical.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get();	
	}

	public List<Student> getAllStudents() {
	
		return studentRepo.findAll();
	}

	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	public void deleteStudent(Long id) {
		Student student=studentRepo.findById(id).get();
		studentRepo.delete(student);
	}
	
}
