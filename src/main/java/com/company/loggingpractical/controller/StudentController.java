package com.company.loggingpractical.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.loggingpractical.entity.Student;
import com.company.loggingpractical.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/add/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		logger.info("Add Students in Student Controller");
	Student studentDetails=studentService.addStudent(student);
	return new ResponseEntity<Student>(studentDetails,HttpStatus.CREATED);
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		logger.info("Get StudentById in Student Controller");
		Student studentDetails=studentService.getStudentById(id);	
		return new ResponseEntity<Student>(studentDetails,HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		logger.info("Get All Students in Student Controller");
		List<Student> students=studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@PutMapping("/update/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		logger.info("Update Student in Student Controller");
		Student studentDetails=studentService.updateStudent(student);
		return new ResponseEntity<Student>(studentDetails,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		logger.info("Delete Students in Student Controller");
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student with Id :"+id+" Deleted Successfully",HttpStatus.OK);
	}
	
}
