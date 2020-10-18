package com.tutorials.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorials.entity.Student;
import com.tutorials.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentrepo;
	
	public List<Student> getAllStudent(){
		return studentrepo.findAll();
	}
	public Student AddStudent(Student student){
		return studentrepo.save(student);
	}
	public Optional<Student> GetStudentById(String id){
		return studentrepo.findById(Integer.parseInt(id));
	}

	public Boolean existById(String id){
		return studentrepo.existsById(Integer.parseInt(id));
	}
	
	public void deleteById(String id){
		 studentrepo.deleteById(Integer.parseInt(id));
	}
	
	public Optional<Student> updateStudent(String id, Student student){
			return studentrepo.findById(Integer.parseInt(id)).map(d->{
				d.setFirstname(student.getFirstname());
				d.setLastname(student.getLastname());
				d.setMajor(student.getMajor());			
				return studentrepo.save(d);
			});
	}
	
}
