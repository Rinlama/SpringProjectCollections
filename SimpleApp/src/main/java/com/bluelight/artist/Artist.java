package com.bluelight.artist;

import java.util.List;

public class Artist {

	private String id;
	private String name;
	private String description;
	
	public Artist(String id, String name, String descrition) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrition() {
		return description;
	}
	public void setDescrition(String descrition) {
		this.description = descrition;
	}
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
}
