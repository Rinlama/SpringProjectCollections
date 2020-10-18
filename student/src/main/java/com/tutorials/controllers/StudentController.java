package com.tutorials.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.entity.Student;
import com.tutorials.services.StudentService;

@RestController
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	StudentService studentservice;

	@RequestMapping(value="/students",method=RequestMethod.GET)
	public List<Student> getAllStudent(){
		return studentservice.getAllStudent();
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getStudentById(@PathVariable("id") String id){
		if(studentservice.existById(id)){
			return ResponseEntity.ok().body(studentservice.GetStudentById(id));
		}else{
			HashMap<String, String> message=new HashMap<String,String>();
			message.put("message", "Object not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	
	@RequestMapping(value="/students",method=RequestMethod.POST)
	public Student addStudent(@Valid @RequestBody Student student){
		return studentservice.AddStudent(student);
	}
	@RequestMapping(value="/students/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@PathVariable("id") String id,@Valid @RequestBody Student student){
		if(studentservice.existById(id)){
			Optional<Student> studentOptional= studentservice.updateStudent(id, student);
			return ResponseEntity.ok().body(studentOptional);
		}else{
			HashMap<String, String> message=new HashMap<String,String>();
			message.put("message", "Object not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	
	@RequestMapping(value="/students/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudent(@PathVariable("id") String id){
		if(studentservice.existById(id)){
			studentservice.deleteById(id);
			HashMap<String, String> message=new HashMap<String,String>();
			message.put("message", "Student Remove");
			return ResponseEntity.ok().body(message);
		}else{
			HashMap<String, String> message=new HashMap<String,String>();
			message.put("message", "Object not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	
}
