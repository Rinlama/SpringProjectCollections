package com.model;

public class Student {
	public Student(int id, String name, String major) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
	}
	private int id; 
	private String name;
	private String major;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", major=" + major + "]";
	}
}
