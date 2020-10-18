package com.tutorials.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull(message="firstname required")
	private String firstname;
	@NotNull(message="lastname required")
	private String lastname;
	@NotNull(message="major required")
	private String major;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String firstname, String lastname, String major) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.major = major;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

}
