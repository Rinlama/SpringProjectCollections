package services;

import java.util.ArrayList;

import com.model.Student;

public class StudentService {
	public ArrayList<Student> students;
	
	public StudentService(){
		this.students=new ArrayList<Student>();
		students.add(new Student(1,"Sam","IT"));
		students.add(new Student(2,"Ren","CST"));
		students.add(new Student(3,"Harry","MS"));
	}
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	public Student getById(int id){
		 Student temstuden;
		for(int i=0; i<this.students.size();i++){
			if(this.students.get(i).getId()==id){
				return this.students.get(i);
			}
		}
		return null;
		
	}
	
}
