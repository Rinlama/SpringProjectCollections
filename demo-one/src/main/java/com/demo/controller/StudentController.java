package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;

@RestController
public class StudentController {

	@RequestMapping(method=RequestMethod.GET,value="/students")
	public List<Student> getAllStudents(){
		ArrayList<Student> list= new ArrayList();
		list.add(new Student(1,"Adams","Computer System"));
		list.add(new Student(2,"Jerry","Computer Science"));
		list.add(new Student(3,"Peter","Business Admin"));
		return list;
	}
}
